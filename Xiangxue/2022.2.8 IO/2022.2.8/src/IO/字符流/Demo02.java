package IO.字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/IO/字符流/1.txt");
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c + " ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
