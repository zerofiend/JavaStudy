package 基础内容.Object;

import java.util.HashSet;

public class Demo02 {
    public static void main(String[] args) {
        EqualImp e1 = new EqualImp(1,1,1);
        EqualImp e2 = new EqualImp(1,1,1);
        HashSet<EqualImp> hashSet = new HashSet<>();
        hashSet.add(e1);
        hashSet.add(e2);

        System.out.println(hashSet.size());
    }
}
