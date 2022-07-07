import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 常用类
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  System类
        long time = System.currentTimeMillis();
        System.out.println(time);
        //  BigInteger类
        System.out.println("请输入第一个大整数：");
        String str1 = scanner.next();
        System.out.println("请输入第二个大整数：");
        String str2 = scanner.next();
        BigInteger bigInteger1 = new BigInteger(str1);
        BigInteger bigInteger2 = new BigInteger(str2);
        System.out.println("两数之和为：" + bigInteger1.add(bigInteger2));
        System.out.println("两数之差为：" + bigInteger1.subtract(bigInteger2));
        System.out.println("两数之积为：" + bigInteger1.multiply(bigInteger2));
        System.out.println("两数之商为：" + bigInteger1.divideAndRemainder(bigInteger2)[0] + "." + bigInteger1.divideAndRemainder(bigInteger2)[1]);
        //  BigDecimal类
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        System.out.println("两数之和为：" + bigDecimal1.add(bigDecimal2));
        System.out.println("两数之差为：" + bigDecimal1.subtract(bigDecimal2));
        System.out.println("两数之积为：" + bigDecimal1.multiply(bigDecimal2));
        System.out.println("两数之商为：" + bigDecimal1.divideAndRemainder(bigDecimal2)[0] + "." + bigDecimal1.divideAndRemainder(bigDecimal2)[1]);
        //  Date类
        Date date1 = new Date();
        System.out.println(date1);
        Date date2 = new Date(time);
        System.out.println(date2);
        System.out.println(date1.after(date2));
        System.out.println(date1.getTime());
        //  SimpleDateFormat类
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf);
        String s = sdf.format(date1);
        System.out.println(s);
        //  自定义日期格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:hh");
        String s2 = sdf2.format(new Date());
        System.out.println(s2);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒hh");
        String s3 = sdf3.format(new Date());
        System.out.println(s3);
    }
}
