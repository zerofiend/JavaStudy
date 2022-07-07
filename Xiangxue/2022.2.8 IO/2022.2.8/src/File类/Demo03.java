package File类;

import java.io.File;

/**
 * 删除文件
 */
public class Demo03 {
    public static void main(String[] args) {
        File file = new File("src/File类/abc/aa.txt");
        boolean delete = file.delete();
        System.out.println(delete);
    }
}
