package IO.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static IO.字节流.Demo02.copyPath;
import static IO.字节流.Demo02.logoPath;

/**
 * 拷贝图片（定义数组长度）
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(logoPath);
        FileOutputStream fileOutputStream = new FileOutputStream(copyPath);
        int len = 0;
        byte[] b = new byte[1024 * 8];
        long time1 = System.currentTimeMillis();
        while ((len = fileInputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, len);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("总共耗时：" + (time2 - time1) + "ms");
        fileOutputStream.close();
        fileInputStream.close();
    }
}
