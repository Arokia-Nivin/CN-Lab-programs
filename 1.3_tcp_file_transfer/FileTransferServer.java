import java.io.*;
import java.net.*;

public class FileTransferServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();

        // Specify the file
        File file = new File("./data1.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        // Get client's output stream
        OutputStream os = client.getOutputStream();

        // Read File Contents into contents array byte[] contents;
        long fileLength = file.length();
        long current = 0;

        while (current < fileLength) {
            int size = 10000;
            size=Math.min(10000, (int)(fileLength-current)); 
            current+=size; 

            byte[] contents = new byte[size];
            bis.read(contents, 0, size);
            os.write(contents);
            System.out.print("Sending file ... " + (current * 100) / fileLength + "% complete!");
        }

        os.flush();
        bis.close();
        server.close();
        System.out.println("File sent succesfully!");
    }
}
