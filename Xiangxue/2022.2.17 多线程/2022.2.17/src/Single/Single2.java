package Single;

/**
 * 懒汉式
 */
public class Single2 {
    private static Single2 single = null;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (single == null) {
            single = new Single2();
        }
        return single;
    }
}
