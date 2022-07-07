package File类;

import java.io.File;

/**
 * 案例1：
 * 获取路径下所有.txt类型的文件并输出文件名
 */
public class Test01 {
    public static void main(String[] args) {
        File direction = new File("src/File类");
        serch(direction);
    }

    public static void serch(File direction) {
        File[] files = direction.listFiles();
        for (File file : files) {
            /*  若存在文件夹，则进入新文件夹  */
            if (file.isDirectory()) {
                serch(file);
            } else if (file.getName().endsWith("txt")) {
                System.out.println("名称：" + file.getName());
            }
        }
    }
}
