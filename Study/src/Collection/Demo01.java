package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {
    public static void main(String[] args) {
        Collection collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        Collection collection2 = new ArrayList();
        collection2.add(1);
        collection2.add(2);
        collection2.add(3);
        System.out.println(collection1.containsAll(collection2));
    }
}
