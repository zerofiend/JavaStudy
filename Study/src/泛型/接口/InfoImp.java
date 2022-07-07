package 泛型.接口;

public class InfoImp<T> implements Info<T>{
    private T var;

    @Override
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    public InfoImp(T var) {
        this.var = var;
    }
}
