import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) {
    
        try {
            Socket server = new Socket("localhost", 9999);

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));

            PrintWriter toServer = new PrintWriter(server.getOutputStream(), true);

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));

            while(true)
            {
                String serverMsg=fromServer.readLine();
                
                if (serverMsg != null)
                    System.out.println(serverMsg);

                String clientMsg = fromClient.readLine();

                toServer.println(clientMsg);
                
                if (clientMsg.trim().equals("bye")){
                    server.close();
                    break; 
                }
            }
        } 
        catch (Exception err)
        {
            System.err.println(err);
        }
    }
}

