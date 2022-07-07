package 泛型.方法;

public class User {
    public <T> T getUser(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }
}
