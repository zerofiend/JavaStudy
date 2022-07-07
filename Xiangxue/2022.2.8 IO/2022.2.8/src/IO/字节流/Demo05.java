package IO.字节流;

import java.io.*;

import static IO.字节流.Demo02.copyPath;
import static IO.字节流.Demo02.logoPath;

/**
 * 拷贝图片（Buffered）
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(logoPath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(copyPath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int b = 0;
        long time1 = System.currentTimeMillis();
        while ((b = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(b);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("总共耗时：" + (time2 - time1) + "ms");
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
