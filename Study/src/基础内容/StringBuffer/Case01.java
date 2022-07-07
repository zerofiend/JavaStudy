package 基础内容.StringBuffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 将Student数组内容转换成字符串
 */
public class Case01 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("小明",18,"男"));
        list.add(new Student("小红",19,"女"));
        list.add(new Student("小华",20,"男"));

        StringBuffer stringBuffer = new StringBuffer();
        for(Student student : list) {
            stringBuffer.append(student);
            stringBuffer.append("@");
        }
        String str = stringBuffer.toString();
        String[] arr = str.split("@");
        for(String s : arr) {
            System.out.println(s);
        }
    }
}
