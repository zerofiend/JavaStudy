package 面向对象.三大特性.继承;

public class Cat extends Animal{
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", color='" + color + '\'' +
                '}';
    }
}
