package IO流.Demo02;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        File image = new File("Study/src/IO流/Demo02/new.png");
        boolean delete = image.delete();    //删除上一次复制的图片
        try {
            Thread.sleep(3000); //等待三秒
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("Study/src/IO流/Demo02/old.png");
            fileOutputStream = new FileOutputStream("Study/src/IO流/Demo02/new.png");
            byte[] b = new byte[1024 * 8];
            int len = 0;
            while ((len = fileInputStream.read(b)) != -1) {
                System.out.println(len);
                fileOutputStream.write(b, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
