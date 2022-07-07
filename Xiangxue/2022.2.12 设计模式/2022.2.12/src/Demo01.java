import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 按指定编码拷贝文件（不推荐）
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/1.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        FileOutputStream fileOutputStream = new FileOutputStream("src/2.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
        int b = 0;
        while ((b = inputStreamReader.read()) != -1) {
            outputStreamWriter.write(b);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
