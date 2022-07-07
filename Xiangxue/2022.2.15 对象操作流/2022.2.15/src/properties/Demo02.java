package properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 利用Properties类来写入文件内容
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        store();
        load();
    }

    public static void store() throws IOException {
        FileWriter fileWriter = new FileWriter("src/properties/1.txt");
        Properties properties = new Properties();
        properties.put("01", "张三");
        properties.put("02", "李四");
        properties.put("03", "王五");
        properties.store(fileWriter, null);
        fileWriter.close();
    }

    public static void load() throws IOException {
        FileReader fileReader = new FileReader("src/properties/1.txt");
        Properties properties = new Properties();
        properties.load(fileReader);
        System.out.println(properties);
        fileReader.close();
    }
}
