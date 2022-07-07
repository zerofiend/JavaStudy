package 基础内容.String;

import java.util.Scanner;

/**
 * 统计大字符串中小字符串的个数
 */
public class Case04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入大字符串：");
        String longStr = sc.next();
        System.out.println("请输入小字符串：");
        String shortStr = sc.next();
        int num = 0;
        while(longStr.indexOf(shortStr)!=-1) {
            int index = longStr.indexOf(shortStr);
            longStr = longStr.substring(index+shortStr.length());
            num++;
        }
        System.out.println("大字符串中一共含有"+num+"个小字符串");
    }
}
