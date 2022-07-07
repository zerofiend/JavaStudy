package Internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Server端
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //  创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(7777);
        //  等待用户连接  有阻塞作用
        Socket socket = serverSocket.accept();
        ServerReceive serverReceive = new ServerReceive(socket);
        ServerSend serverSend = new ServerSend(socket);
        serverReceive.start();
        serverSend.start();
    }
}

class ServerSend extends Thread {
    private final Socket socket;

    public ServerSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        String msg;
        try {
            outputStream = socket.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            while (true) {
                System.out.println("请服务端输入内容：");
                msg = new Scanner(System.in).next();
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ServerReceive extends Thread {
    private final Socket socket;

    public ServerReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String msg;
        try {
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                System.out.println("服务端接收到信息：" + bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}