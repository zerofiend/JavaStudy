package 面向对象.三大特性.继承;

public class Bird extends Animal{
    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", color='" + color + '\'' +
                '}';
    }
}
