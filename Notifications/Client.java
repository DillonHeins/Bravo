import java.net.*;
import java.io.*;

public class Client extends Thread
{
    Socket sock;

    volatile PrintWriter writer;
    volatile BufferedReader reader;
    volatile boolean running = false;

    public Client(String host, Integer port)
    {
        super();

        try
        {
            Socket sock = new Socket(host, port);

            writer = new PrintWriter( sock.getOutputStream() );

            reader = new BufferedReader(new InputStreamReader( sock.getInputStream() ) );
        } 
        catch ( IOException e )
        {
            e.toString();
        }
    }

    public void terminate()
    {
        try
        {
            running = false;
            writer.close();
            reader.close();
        } 
        catch ( IOException e )
        {
            e.toString();
        }
    }

    @Override
    public void start()
    {
        running = true;
        super.start();
    }

    @Override
    public void run()
    {
        try
        {
            String msg;
            
            while( running && (msg = reader.readLine() ) != null )
            {
              System.out.println(msg);
            }

            reader.close();
        } 
        catch ( IOException e )
        {
           e.toString();
        }
        finally
        {
          terminate();
        }
    }

    public void send( String msg )
    {
        writer.println(msg);
        writer.flush();
    }

    public static void main(String args[])
    {
      Client c = new Client("kendy.up.ac.za", 25);
      c.start();

      try
      {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String msg;

        while(!(msg = reader.readLine()).equals("BYE") && c.running)
        {
          c.send(msg);
        }

        c.terminate();
      } 
      catch(Exception e)
      {
        e.toString();
      }
    }
}
