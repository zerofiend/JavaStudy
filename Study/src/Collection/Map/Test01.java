package Collection.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 统计字符出现的次数
 */
public class Test01 {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        System.out.println("请输入一串字符：");
        String inputString = new Scanner(System.in).next();
        char[] chars = inputString.toCharArray();
        for(char c : chars) {
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}
