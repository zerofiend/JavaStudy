import java.util.Arrays;
import java.util.Scanner;

/**
 * 利用正则表达式将给定字符串排序
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println("请输入一串待排序的字符串数组：");
        String str = new Scanner(System.in).nextLine();
        str = str.trim();
        String[] arr = str.split(" ");
        Arrays.sort(arr);
        String ans = "";
        for (String s : arr) {
            ans += s + " ";
        }
        System.out.println("排序后的字符串为：" + ans);

    }
}
