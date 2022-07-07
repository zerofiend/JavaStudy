package 基础内容.String;

public class Demo02 {
    public static void main(String[] args) {
        String str1 = "ddd";
        String str2 = new String("ddd");
        String str3 = "ddd";
        String str4 = str1.intern();
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4);
    }
}
