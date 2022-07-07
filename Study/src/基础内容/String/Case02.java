package 基础内容.String;

import java.util.Scanner;

/**
 * 首字母大写其余小写
 */
public class Case02 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符");
        String sen = new Scanner(System.in).next();
        String head = sen.substring(0,1).toUpperCase();
        String other = sen.substring(1, sen.length()).toLowerCase();
        String ans = head.concat(other);
        System.out.println(ans);
    }
}
