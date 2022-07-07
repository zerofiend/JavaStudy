package IO.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static IO.字节流.Demo02.copyPath;
import static IO.字节流.Demo02.logoPath;

/**
 * 图片拷贝（available()）
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(logoPath);
        FileOutputStream fileOutputStream = new FileOutputStream(copyPath);
        byte[] b = new byte[fileInputStream.available()];
        long time1 = System.currentTimeMillis();
        while (fileInputStream.read(b) != -1) {
            fileOutputStream.write(b);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("总共耗时：" + (time2 - time1) + "ms");
        fileOutputStream.close();
        fileInputStream.close();
    }
}
