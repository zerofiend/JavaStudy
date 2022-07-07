package design;

public class TestSuperHero {
    public static void main(String[] args) {
        Tony tony = new Tony();
        tony.work();
        tony.saveWorld();
        IronMan ironMan = new IronMan(tony);
        ironMan.work();
        ironMan.saveWorld();
    }
}
