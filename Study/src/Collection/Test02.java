package Collection;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 输入一段重复的字符，然后去重输出
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println("请输入一段字符：");
        String inputString = new Scanner(System.in).next();
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        char[] chars = inputString.toCharArray();
        for(char c : chars) {
            Character character = c;
            linkedHashSet.add(c);
        }
        System.out.println("去重后的字符段为："+linkedHashSet);
    }
}
