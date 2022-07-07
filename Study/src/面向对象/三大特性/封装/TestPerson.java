package 面向对象.三大特性.封装;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setAge(18);
        p2.setAge(80);
        p1.setGender(0);
        p2.setGender(1);
        p1.setName("张三");
        p2.setName("李四");
        p1.getGender();
        p1.work();
        p2.getGender();
        p2.work();
    }
}
