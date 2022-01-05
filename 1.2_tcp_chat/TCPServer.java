import java.io.*;
import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        try {
            ServerSocket Server = new ServerSocket(5000);
            System.out.println("TCPServer Waiting for client on port 5000... ");
            
            Socket client = Server.accept();

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            System.out.println("SEND(Type Q or q to Quit):");
            while (true) {

                String serverMsg = fromServer.readLine();

                if (serverMsg.equals("q") || serverMsg.equals("Q")) {
                    toClient.println(serverMsg);
                    client.close();
                    break;
                } else {
                    toClient.println(serverMsg);
                }

                String clientMsg = fromClient.readLine();

                if (clientMsg.equals("q") || clientMsg.equals("Q")) {
                    client.close();
                    break;
                } else {
                    System.out.println("RECIEVED:" + clientMsg);	
                }

            }
            Server.close();

            
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
    }
}

