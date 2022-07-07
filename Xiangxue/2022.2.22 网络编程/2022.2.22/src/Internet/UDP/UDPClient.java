package Internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //  建立码头
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket packet = null;
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        String msg = null;
        while (true) {
            //  输入信息
            System.out.println("请输入信息：");
            msg = new Scanner(System.in).next();
            //  整顿信息
            byte[] b = msg.getBytes();
            //  装箱
            packet = new DatagramPacket(b, b.length, ip, 8888);
            datagramSocket.send(packet);
        }
    }
}
