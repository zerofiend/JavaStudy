package 基础内容.String;

public class Demo01 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        String s3 = "bbb";
        String s4 = "bbb";
        System.out.println(s3 == s4);
        String s5 = s1.intern();
        System.out.println(s1.intern() == s5);
    }
}
