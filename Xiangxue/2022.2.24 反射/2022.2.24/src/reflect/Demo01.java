package reflect;

/**
 * 三种获取class对象的方法
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //  第一种
        Class<?> c1 = Class.forName("reflect.Person");
        //  第二种
        final Class<Person> c2 = Person.class;
        //  第三种
        Person p = new Person();
        Class<? extends Person> c3 = p.getClass();
        //  比较三种获取的class对象是否相同
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
