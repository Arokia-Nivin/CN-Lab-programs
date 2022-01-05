import java.io.*;
import java.net.*;

class Clientarp {
    public static void main(String args[]) {
        try {

            Socket server = new Socket("localhost", 3000);

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream())); 
            PrintWriter toServer= new PrintWriter(server.getOutputStream(), true);

            System.out.println("Enter the Logical address(IP):");

            /*inputs -  
                    "165.165.80.80",
                    "165.165.79.1"
            */
            String IP = fromClient.readLine();
            toServer.println(IP);
            
            String MAC = fromServer.readLine();

            System.out.println("The Physical Address is: " + MAC);
            
            server.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}