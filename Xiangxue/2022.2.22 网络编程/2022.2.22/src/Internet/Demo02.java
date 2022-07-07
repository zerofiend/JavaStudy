package Internet;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/?tn=15007414_pg");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("域名：" + url.getHost());
            System.out.println("端口：" + url.getPort());
            System.out.println("资源：" + url.getFile());
            System.out.println("锚点：" + url.getRef());
            System.out.println("相对路径：" + url.getPath());
            System.out.println("参数：" + url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
