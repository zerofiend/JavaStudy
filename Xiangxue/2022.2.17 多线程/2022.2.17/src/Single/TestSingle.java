package Single;

public class TestSingle {
    public static void main(String[] args) {
        Single1 single1 = Single1.getInstance();
        Single1 single2 = Single1.getInstance();
        System.out.println(single1 == single2);
    }
}
