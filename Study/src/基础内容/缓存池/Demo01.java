package 基础内容.缓存池;

public class Demo01 {
    public static void main(String[] args) {
//        直接创建新地址
        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);
        System.out.println(i1 == i2);   //  false
//        直接从缓存池中找123的地址
        Integer i3 = Integer.valueOf(123);
        Integer i4 = Integer.valueOf(123);
        System.out.println(i3 == i4);   //  true
    }
}
