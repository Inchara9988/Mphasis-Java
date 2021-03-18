import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileAndBufferReader {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("FileReaderDemo.java");
        BufferedReader br = new BufferedReader(fr);
        String s;

        while((s = br.toString()) != null) {
            System.out.println(s);
        }

        fr.close();
    }
}
