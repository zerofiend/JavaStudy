package Internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //  创建港口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //  创建集装箱
        byte[] b;
        //  创建货运车
        DatagramPacket packet = null;
        //  数据装上集装箱，阻塞作用，等待用户连接
        while (true) {
            b = new byte[1024 * 8];
            packet = new DatagramPacket(b, 1024 * 8);
            datagramSocket.receive(packet);

            //  获取用户信息
            String msg = new String(b).split("\0")[0];
            InetAddress ip = packet.getAddress();
            System.out.println("接收到了来自" + ip + "的信息：" + msg);
        }
    }
}
