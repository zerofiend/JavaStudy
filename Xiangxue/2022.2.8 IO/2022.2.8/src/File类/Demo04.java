package File类;

import java.io.File;

/**
 * FIle类判断功能
 */
public class Demo04 {
    public static void main(String[] args) {
        File file = new File("src/File类/Demo01.java");
        boolean isFile = file.isFile();
        System.out.println("是否为文件：" + isFile);
        boolean isDirectory = file.isDirectory();
        System.out.println("是否为文件夹：" + isDirectory);
        boolean isExists = file.exists();
        System.out.println("是否存在：" + isExists);
        boolean canRead = file.canRead();
        System.out.println("是否可读：" + canRead);
        boolean canWrite = file.canWrite();
        System.out.println("是否可写：" + canWrite);
        boolean isHidden = file.isHidden();
        System.out.println("是否隐藏：" + isHidden);
    }
}
