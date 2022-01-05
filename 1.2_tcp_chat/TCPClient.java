
import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {

        Socket server = new Socket("localhost", 5000);
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        
        PrintWriter toServer = new PrintWriter(server.getOutputStream(), true);
        System.out.println("SEND(Type Q or q to Quit):");

        while (true) {

            String serverMsg = fromServer.readLine();

            if (serverMsg.equals("q") || serverMsg.equals("Q")) 
            {
                server.close();
                break;

            } else 
            {
                System.out.println("RECIEVED:" + serverMsg);
            }
                
            String clientMsg = fromClient.readLine();
            if (clientMsg.equals("Q") || clientMsg.equals("q"))
            {
                toServer.println(clientMsg);
                server.close();
                break;
			} else
            {
                toServer.println(clientMsg);
            }
           
        }
    }
}

