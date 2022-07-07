package 泛型.上限;

import java.util.List;

public class Test {
    public static void funA(A a) {

    }
    public static void funB(B b) {
        funA(b);
    }
    //  未设定下限
/*    public static void funC(List<A> a) {

    }*/
    //  设定下限
    public static void funC(List<? extends A> a) {

    }
    public static void funD(List<B> b) {
        funC(b);
    }
}
class A{}
class B extends A {}


