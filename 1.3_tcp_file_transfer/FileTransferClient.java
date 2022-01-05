import java.io.*;
import java.net.*;

public class FileTransferClient {
    public static void main(String[] args) throws Exception {
    
        //Initialize socket
        Socket server = new Socket("localhost", 5000);
        byte[] contents = new byte[10000];

        //Initialize the FileOutputStream to the output file's full path.
        File file = new File("./data2.txt"); 
        FileOutputStream fos = new FileOutputStream(file); 
        BufferedOutputStream bos = new BufferedOutputStream(fos); 
        InputStream is = server.getInputStream();

        int bytsread=is.read(contents); 
        
        bos.write(contents,0,bytsread);
        
        bos.flush();
        bos.close();
        
        server.close();
        System.out.println("File saved successfully!");
    }
}




