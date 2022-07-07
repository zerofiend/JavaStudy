package Collection;

import java.util.Random;
import java.util.TreeSet;

/**
 * 获取10个10~20的随机数，且不能重复
 */
public class Test01 {
    public static void main(String[] args) {
        Random random = new Random();
        TreeSet<Integer> treeSet = new TreeSet<>();
        while(treeSet.size()<10) {
            treeSet.add(random.nextInt(10)+10);
        }
        System.out.println(treeSet);
    }
}
