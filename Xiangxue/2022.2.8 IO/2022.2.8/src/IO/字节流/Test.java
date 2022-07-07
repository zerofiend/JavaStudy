package IO.字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 案例：
 * 输入内容存入文件
 */
public class Test {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src/IO/字节流/write.txt");
            while (true) {
                String input = new Scanner(System.in).nextLine();
                if (input.equals("quit")) {
                    break;
                }
                byte[] b = input.getBytes();
                fileOutputStream.write(b);
                fileOutputStream.write("\r\n".getBytes());
                fileOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
