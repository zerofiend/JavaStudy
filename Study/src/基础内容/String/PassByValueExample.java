package 基础内容.String;

public class PassByValueExample {
    public static void main(String[] args) {
/*        Dog dog = new Dog("A");
        System.out.println(dog.getNameAddress());
        System.out.println("----------------------");
        func(dog);
        System.out.println("----------------------");
        System.out.println(dog.getNameAddress());
        System.out.println(dog.getName());*/
        Dog dog = new Dog("A");
        func(dog);
        System.out.println(dog.getName());
    }

    private static void func(Dog dog) {
/*        System.out.println(dog.getNameAddress());
        dog = new Dog("B");
        System.out.println(dog.getNameAddress());
        System.out.println(dog.getName());*/
        dog.setName("B");
    }
}
