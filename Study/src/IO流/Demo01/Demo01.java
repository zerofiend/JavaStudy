package IO流.Demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 创建文件
 */
public class Demo01 {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\ZFiend\\JavaFullStackStudy\\Study\\src\\IO流\\Demo01\\text.txt", true)) {
            fileOutputStream.write(101);
            fileOutputStream.write(100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
