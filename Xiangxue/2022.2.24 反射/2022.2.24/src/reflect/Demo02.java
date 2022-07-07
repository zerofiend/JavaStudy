package reflect;

public class Demo02 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        final Class<Person> c = Person.class;
        Person person = c.newInstance();
        person.age = 10;
        person.name = "张三";
        Person.print();
        System.out.println(person);
    }
}
