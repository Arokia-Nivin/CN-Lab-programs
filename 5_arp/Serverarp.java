import java.io.*;
import java.net.*;

class Serverarp {
    public static void main(String args[]) throws Exception {
        try {
            ServerSocket server = new ServerSocket(3000);
            while(true){
                System.out.println("Waiting For Client...");
                Socket client = server.accept();

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
                PrintWriter toCilent= new PrintWriter(client.getOutputStream(), true);

                String str = fromClient.readLine();
                
                String ip[] = {
                    "165.165.80.80",
                    "165.165.79.1"
                };
                String mac[] = {
                    "6A:08:AA:C2",
                    "8A:BC:E3:FA"
                };
                for (int i = 0; i < ip.length; i++) {
                    if (str.equals(ip[i])) {
                        toCilent.println(mac[i]);
                        client.close();
                        break;
                    }
                }
            }   
      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
