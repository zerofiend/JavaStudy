package 泛型.上下限;

public class Max {
    public static void main(String[] args) {
        Info<Integer> i1 = new Info<>();
    }
}

class Info<T extends Number> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return var.toString();
    }
}
