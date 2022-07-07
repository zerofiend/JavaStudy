import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算自己活了多少天
 */
public class Test05 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入你的生日：");
        String birthday = new Scanner(System.in).next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date d = sdf.parse(birthday);
        long time1 = d.getTime();
        long time2 = System.currentTimeMillis();
        System.out.println("你已经活了" + (time2 - time1) / 1000 / 3600 / 24 + "天。");
    }
}
