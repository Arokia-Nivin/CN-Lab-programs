import java.io.*;

class pingserver {

    public static void main(String[] args) {

        try
        {

            System.out.println("Enter the IP Address");

            BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));

            String IP = buf1.readLine();

            Runtime r = Runtime.getRuntime();

            Process p = r.exec("ping " + IP);

            BufferedReader buf2 = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String str;

            while (true)

            {

                str = buf2.readLine();

                if (str == null)

                    break;

                System.out.println(str);

            }

        } catch (Exception e)

        {

            System.out.println(e.toString());

        }

    }

}