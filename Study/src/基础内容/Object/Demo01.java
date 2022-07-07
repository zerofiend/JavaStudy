package 基础内容.Object;

/**
 * equals()
 */
public class Demo01 {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
