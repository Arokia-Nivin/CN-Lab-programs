import java.net.*;
import java.io.*;
class rarp {
    public static void main(String[] args) {
        try {
            BufferedReader fromUser= new BufferedReader(new InputStreamReader(System.in)); 

            // run "hostame" command in cmd to view the system name 
            System.out.println("Enter System Name: ");
            String systemName = fromUser.readLine(); 

            InetAddress address = InetAddress.getByName(systemName);
            System.out.println("address = " + address);
            
            NetworkInterface NI = NetworkInterface.getByInetAddress(address);
            if (NI != null) {
                byte[] mac = NI.getHardwareAddress();

                if (mac != null) {
                    System.out.print("MAC Address : ");

                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                } 
                else 
                {
                    System.out.println("Address doesn't exist or is not accessible/");
                }
            } 
            else 
            {
                System.out.println("Network Interface for the specified address is not found");
            }

            fromUser.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}