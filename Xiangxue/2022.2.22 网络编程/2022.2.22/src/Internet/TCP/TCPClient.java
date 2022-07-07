package Internet.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7777);
        ClientReceive clientReceive = new ClientReceive(socket);
        ClientSend clientSend = new ClientSend(socket);
        clientReceive.start();
        clientSend.start();
    }
}

class ClientSend extends Thread {
    private final Socket socket;

    public ClientSend(Socket socket) {
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
                System.out.println("请客户端输入内容：");
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

class ClientReceive extends Thread {
    private final Socket socket;

    public ClientReceive(Socket socket) {
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
                System.out.println("客户端接收到信息：" + bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}