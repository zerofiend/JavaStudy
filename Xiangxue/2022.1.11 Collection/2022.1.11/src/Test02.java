import java.util.Scanner;

/**
 * 通过异常判断输入的是否为数字
 */
public class Test02 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入一串数字字符：");
            String str = new Scanner(System.in).next();
            change(str);
        }
    }

    public static void change(String str) {
        try {
            Integer integer = new Integer(str);
            String ans = Integer.toBinaryString(integer);
            System.out.println("这个数的二进制表示为：" + ans);
            System.exit(0);
        } catch (NumberFormatException e1) {
            try {
                new Double(str);
                System.out.println("输入的是小数，请重新输入！");
            } catch (Exception e2) {
                e2 = new DecimalException("输入的内容含有字符，请重新输入！");
                e2.printStackTrace();
            }
        }
    }
}

class DecimalException extends Exception {
    public DecimalException() {
        super();
    }

    public DecimalException(String message) {
        super(message);
    }
}
