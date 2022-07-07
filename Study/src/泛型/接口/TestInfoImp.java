package 泛型.接口;

public class TestInfoImp {
    public static void main(String[] args) {
        InfoImp<String> infoImp = new InfoImp<>("123");
        System.out.println(infoImp.getVar());
    }
}
