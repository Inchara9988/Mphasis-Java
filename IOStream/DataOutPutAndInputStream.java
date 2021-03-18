import java.io.*;

public class DataOutPutAndInputStream {
    public static void main(String args[]) throws IOException {
          
        //creating file and data output Stream
        FileOutputStream fout = new FileOutputStream("D:/java/Test.dat");
        DataOutputStream out = new DataOutputStream(fout);

        out.writeDouble(98.6);
        out.write(1000);
        out.writeBoolean(true);

        out.close();
        
        //creating file and data ouptput stream
        FileInputStream fin = new FileInputStream("Test.dat");
        DataInputStream in = new DataInputStream(fin);

        double d = in.readDouble();
        int i = in.readInt();
        boolean b = in.readBoolean();

        System.out.println("Here are the values:  " +
                d + " " + i + " " + b);

        in.close();
    }
}
