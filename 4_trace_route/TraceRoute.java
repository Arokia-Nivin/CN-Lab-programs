import java.io.*;

class TraceRoute {

    public static void main(String[] args) {

        try
        {


            BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));

            Runtime r = Runtime.getRuntime();

            Process p = r.exec("tracert www.google.com");

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