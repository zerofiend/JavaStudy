package 面向对象.三大特性.继承;

public class TestAnimal {
    /**
     * Animal和Bird、Cat、Dog是is和a的关系
     *
     * 可以用Animal对Cat引用对象，称为向上转型
     */
    public static void main(String[] args) {
        Animal b = new Bird();
        Animal c = new Cat();
        Animal d = new Dog();
        b.setName("小鸟");
        c.setName("小猫");
        d.setName("小狗");
        b.setColor("黑色");
        c.setColor("白色");
        d.setColor("灰色");
        b.setLegs(2);
        c.setLegs(4);
        d.setLegs(4);
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
    }
}
