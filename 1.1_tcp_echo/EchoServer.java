import java.io.*;
import java.net.*;

public class EchoServer {
    ServerSocket server;

    //constructor 
    public EchoServer() 
    {
        try 
        {
            server = new ServerSocket(9999);
        } 
        catch (Exception err) 
        {
            System.out.println(err);
        }
    }
    
    public void serve() {
        try {
            while (true) 
            {
                System.out.println("Waiting for client");
                
                Socket client = server.accept();
    
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
                PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

                toClient.println("Welcome to the Java EchoServer.Type 'bye' to close.");
                
                while(true)
                {
                    String clientmsg = fromClient.readLine();
                    
                    if(clientmsg != null)
                    {
                        toClient.println("Got: "+clientmsg); 

                        System.out.println("received from client: "+clientmsg);
                    }
                    if (clientmsg.trim().equals("bye"))
                        break; 
                }
                    
                client.close();
            }
        }
         catch (Exception err) 
        {
            System.err.println(err);
        }
    }
    
    public static void main(String[] args) {
        EchoServer s = new EchoServer();
        s.serve();
    }
    
}