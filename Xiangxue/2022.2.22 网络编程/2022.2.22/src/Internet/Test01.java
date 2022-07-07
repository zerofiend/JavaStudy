package Internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 简易爬虫
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.ahpu.edu.cn/");
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] b = new byte[1024 * 8];
        int len = 0;
        while ((len = bufferedInputStream.read(b)) != -1) {
            String str = new String(b, 0, len);
            System.out.println(str);
        }
        bufferedInputStream.close();
    }
}
