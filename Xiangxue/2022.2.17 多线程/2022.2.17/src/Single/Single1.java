package Single;

/**
 * 饿汉式
 */
public class Single1 {
    private static Single1 single = new Single1();

    private Single1() {
    }

    public static Single1 getInstance() {
        return single;
    }
}
