import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 队列和栈
 */
public class Test01 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollFirst();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollLast();
        System.out.println(Arrays.toString(deque.toArray()));
    }
}
