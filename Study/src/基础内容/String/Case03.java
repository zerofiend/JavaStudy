package 基础内容.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串反转
 */
public class Case03 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符串：");
        String str = new Scanner(System.in).next();
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }
}
