import java.util.Scanner;

/**
 * 需求：校验qq号码.
 * 1:要求必须是6-12位数字
 * 2:0不能开头
 * 3:必须都是数字
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符：");
        String str = new Scanner(System.in).next();
        //  一般方法
        System.out.println(usualCheck(str) ? "符合QQ号规则" : "不符合QQ号规则");
        //  正则表达式
        String regex = "[1-9]\\d{5,11}";
        System.out.println(str.matches(regex) ? "符合QQ号规则" : "不符合QQ号规则");
    }

    public static boolean usualCheck(String str) {
        if (str.length() >= 6 && str.length() <= 12) {
            if (str.charAt(0) != '0') {
                for (char c : str.toCharArray()) {
                    if (!(c >= '0' && c <= '9')) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
