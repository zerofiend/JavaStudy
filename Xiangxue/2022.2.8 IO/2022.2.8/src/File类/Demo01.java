package File类;

import java.io.File;
import java.io.IOException;

/*
  创建文件
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("src/File类/a.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*创建新文件夹内文件*/
        File file1 = new File("src/File类/abc");
        File file2 = new File("src/File类/abc/a.txt");
        boolean mkdir = file1.mkdir();
        try {
            boolean newFile = file2.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
