package Collection;

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("张三");
        linkedList.add("李四");
        linkedList.add("王五");
        String first = linkedList.getFirst();
        String last = linkedList.getLast();
        System.out.println("第一个："+first);
        System.out.println("最后一个："+last);
    }
}
