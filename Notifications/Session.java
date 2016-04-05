import java.io.*;
import java.net.*;
import java.util.*;

public class Session
{
    public static final int timeout = 15*1000;

    private String host;
    private int port;
    protected Socket socket;
    protected BufferedReader in;
    protected OutputStreamWriter out;

    private String[] recipient;
    private String sender;
    private String subject;
    private String message;

    public Session(String host, int port, String[] recipient, String sender, String subject, String message)
    {
        this.host = host;
        this.port = port;

        for (int k = 0; k < recipient.length(); k++)
        {
            this.recipient[k] = recipient[k];
        }

        this.message = message;
        this.sender = sender;
        this.subject = subject;
    }

    public Session(String host, String[] recipient, String sender, String subject, String message)
    {
        this(host, 25, recipient, sender, subject, message);
    }
    
    public void close()
    {
        try
        {
            in.close();
            out.close();
            socket.close();
        }
        catch (Exception ex)
        { }
    }

    protected void connect() throws IOException
    {
        socket = new Socket(host, port);

        socket.setSoTimeout(timeout);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new OutputStreamWriter(socket.getOutputStream());
    }

    public void sendMessage() throws IOException
    {
        connect();

        String response = getResponse();
        checkServerResponse(response,'2');

        doCommand("HELO " + socket.getLocalAddress().toString(), '2');
        doCommand("MAIL FROM: <" + sender + ">", '2');

        if (recipient.length == 1)
        {
            doCommand("RCPT TO: <" + recipient[0] + ">", '2');
        }
        else if (recipient.length > 1)
        {
            for (int k = 0; k < recipient.length(); k++)
            {
                doCommand("RCPT TO: <" + recipient[k] + ">", '2');
            }
        }

        doCommand("DATA", '3');

        out.write(getMessageHeaders());

        BufferedReader msgBodyReader = new BufferedReader(new StringReader(message));
        String line;

        while ((line = msgBodyReader.readLine()) != null) {

            if (line.startsWith("."))
            {
                out.write('.');
            }

            out.write(line + "\n");
        }

        doCommand(".", '2');

        close();
    }

}
