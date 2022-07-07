import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher和Pattern使用
 * 读取语句中的电话号码
 */
public class Test03 {
    public static void main(String[] args) {
        String str = "客户登记的手机号为：13647583392,曾用手机号18547389921,第三个手机号15598765432";
        String regex = "1[3-9]\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
