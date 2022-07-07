package Collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

public class TestStackDeque {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(stack);
        Iterator<Integer> iterator = arrayDeque.iterator();
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}
