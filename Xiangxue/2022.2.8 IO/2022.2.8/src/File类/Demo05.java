package File类;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类获取功能
 */
public class Demo05 {
    public static void main(String[] args) {
        File file = new File("src/File类/Demo05.java");
        System.out.println("相对路径：" + file.getPath());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("名称：" + file.getName());
        System.out.println("长度：" + file.length());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:hh");
        String lastModified = sdf.format(new Date(file.lastModified()));
        System.out.println("最后一次修改的时间：" + lastModified);

        File direction = new File("src/File类");
        String[] list = direction.list();
        for (String inf : list) {
            System.out.println(inf);
        }

        File[] files = direction.listFiles();
        for (File file1 : files) {
            System.out.println("名称：" + file1.getName() + "——长度" + file1.length());
        }
    }
}
