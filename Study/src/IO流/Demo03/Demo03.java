package IO流.Demo03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Study/src/IO流/Demo03/text.txt");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            System.out.println("请输入中文内容：");
            String input = new Scanner(System.in).next();
            byte[] bytes = input.getBytes();
            bufferedOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(bufferedOutputStream!=null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
