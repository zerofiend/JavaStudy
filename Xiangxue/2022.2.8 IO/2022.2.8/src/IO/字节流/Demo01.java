package IO.字节流;

import java.io.*;

/**
 * 读取/写入文件内容
 */
public class Demo01 {
    public static String aPath = "src/IO/字节流/a.txt";
    public static String bPath = "src/IO/字节流/b.txt";
    public static String cPath = "src/IO/字节流/c.txt";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(aPath);
        OutputStream outputStream = new FileOutputStream(bPath);
        OutputStream outputStream1 = new FileOutputStream(cPath, true);  //  追加写入
        int b = 0;
        while ((b = inputStream.read()) != -1) {
            System.out.print((char) b);
            outputStream.write(b);
            outputStream1.write(b);
        }
        outputStream1.write('\n');
        inputStream.close();
        outputStream.close();
        outputStream1.close();
    }
}
