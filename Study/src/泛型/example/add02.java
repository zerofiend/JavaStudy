package 泛型.example;

public class add02 {
    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue()+b.doubleValue();
    }
}
