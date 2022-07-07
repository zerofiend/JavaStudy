package 泛型.类;

public class Point<T> {
    private T point;

    public Point(T point) {
        this.point = point;
    }

    public T getPoint() {
        return point;
    }

    public void setPoint(T point) {
        this.point = point;
    }
}
