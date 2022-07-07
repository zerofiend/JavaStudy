package 泛型.类;

public class TestPoint {
    public static void main(String[] args) {
        Point<String> point = new Point<>("(0,0)");
        System.out.println(point.getPoint().length());
    }
}
