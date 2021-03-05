import java.io.File;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

public class IOStreamEx1 {
    public static void main(String args[]) {
        File f1 = new File("D:/java/contents");
        print("File Name: " + f1.getName());
        print("Path: " + f1.getPath());
        print("Abs Path: " + f1.getAbsolutePath());
        print("Parent: " + f1.getParent());
        print(f1.exists() ? "exists" : "does not exist");
        print(f1.canWrite() ? "is writeable" : "is not writeable");
        print(f1.canRead() ? "is readable" : "is not readable");
        print("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        print(f1.isFile() ? "is normal file" : "might be a named pipe");
        print(f1.isAbsolute() ? "is absolute" : "is not absolute");
        print("File last modified: " + f1.lastModified());
        print("File size: " + f1.length() + " Bytes");
    }

    private static void print(String s) {
    }
}
