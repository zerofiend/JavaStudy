package 面向对象.三大特性.继承;

public class Dog extends Animal{
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", color='" + color + '\'' +
                '}';
    }
}
