package Single;

import java.io.IOException;

/**
 * Runtime类
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();
        r.exec("notepad");
    }
}
