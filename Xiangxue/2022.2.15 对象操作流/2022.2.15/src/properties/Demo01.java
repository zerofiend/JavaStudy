package properties;

import java.util.Properties;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("01", "张三");
        properties.put("02", "李四");
        properties.put("03", "王五");
        Set<Object> keySet = properties.keySet();
        for (Object key : keySet) {
            Object value = properties.get(key);
            System.out.println("键=" + key + " 值=" + value);
        }

        properties.setProperty("01", "张三");
        properties.setProperty("02", "李四");
        properties.setProperty("03", "王五");
        Set<String> names = properties.stringPropertyNames();
        for (String key : names) {
            String value = properties.getProperty(key);
            System.out.println("键=" + key + " 值=" + value);
        }
    }
}
