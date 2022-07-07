package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 互联网协议地址
 */
public class Demo01 {
    public static void main(String[] args) {
        //  获取Ip地址
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);
            System.out.println(inetAddress.getHostName());  //  本地域名
            System.out.println(inetAddress.getHostAddress());   //  ip地址
//            System.out.println(inetAddress.getCanonicalHostName()); //
            System.out.println(InetAddress.getLocalHost()); //  本机地址
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
