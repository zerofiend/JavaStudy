package 基础内容.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * split()的应用
 * 将输入的字符串按照逗号转换成字符串数组
 */
public class Case05 {
    public static void main(String[] args) {
        System.out.println("请输入一串带有逗号分隔的字符串：");
        String str = new Scanner(System.in).next();
        String[] arr = str.split(",");
        System.out.println(Arrays.toString(arr));
    }
}
