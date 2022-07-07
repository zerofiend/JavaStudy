package 泛型.方法;

public class TestUser {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        User user = new User();
        Object object = user.getUser(Class.forName("泛型.方法.User"));
    }
}
