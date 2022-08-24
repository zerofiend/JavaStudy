import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> require = new ArrayList<>();
        require.add(1);
        require.add(3);
        require.add(5);
        List<Integer> ans1 = new ArrayList<>(), ans2 = new ArrayList<>();

//        方法1
        long l1 = System.currentTimeMillis();
        for (Integer n : list) {
            if (!require.contains(n)) {
                ans1.add(n);
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("方法1耗时-----------" + (l2 - l1));

//        方法2
        long l3 = System.currentTimeMillis();
        ans2.addAll((List<Integer>) getSonList(list, require));
        long l4 = System.currentTimeMillis();
        System.out.println("方法2耗时-----------" + (l4 - l3));
    }

    public static List<?> getSonList(List<?> list, List<?> require) {
        for (Object o : list) {
            if (!require.contains(o)) {
                list.remove(o);
            }
        }
        return list;
    }
}
