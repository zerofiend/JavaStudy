package Collection;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 将无序且重复的一个字符串按照字典顺序排序且不能去重
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符：");
        String inputString = new Scanner(System.in).next();
        TreeSet<Character> treeSet = new TreeSet<>(new Order());
        for(char c : inputString.toCharArray()) {
            Character character = c;
            treeSet.add(character);
        }
        System.out.println(treeSet);
    }
}

class Order implements Comparator<Character> {

    @Override
    public int compare(Character o1, Character o2) {
        return o1.compareTo(o2) == 0 ? 1 : o1.compareTo(o2);
    }
}
