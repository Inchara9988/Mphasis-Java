import javafx.util.Builder;
import sun.misc.JarFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;

public class FileFilter
 {
     public static void main(String args[]) {
        String dirname = "D:/java";
        File f1 = new File(dirname);
        FilenameFilter only = new FilenameFilter("html") {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        };
        String s[] = f1.list(only);

        for (int i=0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
