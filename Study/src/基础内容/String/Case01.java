package 基础内容.String;

import java.util.Scanner;

/**
 * 模拟登录
 */
public class Case01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请设置你的密码：");
        String password = sc.next();
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入你的密码：");
            String input = sc.next();
            if (input.equals(password)) {
                System.out.println("密码输入正确！");
                break;
            } else {
                if (i == 2) {
                    System.out.println("你已经用完了所有机会！");
                    System.exit(0);
                }
                System.out.println("密码输入错误！");
                System.out.println("你还有" + (2 - i) + "次机会");
            }
        }
    }
}
