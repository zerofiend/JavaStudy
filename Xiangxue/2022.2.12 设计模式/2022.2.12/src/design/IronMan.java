package design;

/**
 * 装设设计模式
 */
public class IronMan implements SuperHero {
    private final Tony t;

    public IronMan(Tony t) {
        this.t = t;
    }

    @Override
    public void work() {
        System.out.println("拯救世界");
    }

    @Override
    public void saveWorld() {
        fly();
        System.out.println("使用钢铁盔甲");
        fire();
    }

    //  增强功能
    public void fly() {
        System.out.println("我可以飞");
    }

    public void fire() {
        System.out.println("我可以使用掌中炮");
    }

}
