import java.io.*;
import java.net.*;
import java.util.*;

public class Session
{
    public static final int timeout = 15000;

    private String host;
    private int port;
    protected Socket socket;
    protected BufferedReader in;
    protected OutputStreamWriter out;

    private String recipient;
    private String sender;
    private String subject;
    private String message;

    public Session(String host, String recipient, String sender, String subject, String message)
    {
        this(host, 25, recipient, sender, subject, message);
    }

    public Session(String host, int port, String recipient, String sender, String subject, String message)
    {
        this.host = host;
        this.port = port;
        this.recipient = recipient;
        this.message = message;
        this.sender = sender;
        this.subject = subject;
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

    protected String sendCommand(String commandString) throws IOException
    {
        out.write(commandString + "\n");
        out.flush();

        String response = getResponse();

        return response;
    }

    protected void doCommand(String commandString, char expectedResponseStart) throws IOException
    {
        String response = sendCommand(commandString);

        checkServerResponse(response, expectedResponseStart);
    }

    protected void checkServerResponse(String response, char expectedResponseStart) throws IOException
    {
        if (response.charAt(0) != expectedResponseStart)
        {
            throw new IOException(response);
        }
    }

    protected String getResponse() throws IOException
    {
        String response = "";
        String line;

        do
        {
            line = in.readLine();

            if ((line == null) || (line.length() < 3))
            {
                throw new IOException("Bad response from server.");
            }

            response += line + "\n";

        } while ((line.length() > 3) && (line.charAt(3) == '-'));

        return response;
    }

    protected String getMessageHeaders()
    {
        String headers = "";

        headers += "Date: " + new Date().toString() + "\n";
        headers += "Sender: " + sender + "\n";
        headers += "From: " + sender + "\n";
        headers += "To: " + recipient + "\n";
        headers += "Subject: " + subject + "\n";

        return headers + "\n\n";
    }

    public void sendMessage() throws IOException
    {
        connect();

        String response = getResponse();
        checkServerResponse(response,'2');

        doCommand("HELO ish", '2');
        doCommand("MAIL FROM: <" + sender + ">", '2');
        doCommand("RCPT TO: <" + recipient + ">", '2');
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