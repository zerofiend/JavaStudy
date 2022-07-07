package 基础内容.Object;

public class CloneExample implements Cloneable{
    private int a;
    private int b;

    public CloneExample(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "CloneExample{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
