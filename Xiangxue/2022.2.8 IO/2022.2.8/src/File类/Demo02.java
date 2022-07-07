package File类;

import java.io.File;

/**
 * 文件改名
 */
public class Demo02 {
    public static void main(String[] args) {
        File file = new File("src/File类/a.txt");
        File fileName = new File("src/File类/aaa.txt");
        boolean b = file.renameTo(fileName);
        System.out.println(b);
        /*  重命名不在同一文件夹下则是剪切并改名  */
        File file1 = new File("src/File类/aaa.txt");
        File fileName1 = new File("src/File类/abc/aa.txt");
        boolean b1 = file1.renameTo(fileName1);
        System.out.println(b1);
    }
}
