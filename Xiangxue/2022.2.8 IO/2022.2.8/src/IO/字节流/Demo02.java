package IO.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝图片
 */
public class Demo02 {
    public static String logoPath = "src/IO/字节流/01.png";
    public static String copyPath = "src/IO/字节流/copy.png";

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(logoPath);
        FileOutputStream fileOutputStream = new FileOutputStream(copyPath);
        int b = 0;
        long time1 = System.currentTimeMillis();
        while ((b = fileInputStream.read()) != -1) {
            fileOutputStream.write(b);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("总共耗时：" + (time2 - time1) + "ms");
        fileOutputStream.close();
        fileInputStream.close();
    }
}
