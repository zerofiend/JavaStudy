package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('p');
        hashSet.add('p');
        hashSet.add('l');
        hashSet.add('e');
        System.out.println(hashSet);

        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add('a');
        linkedHashSet.add('p');
        linkedHashSet.add('p');
        linkedHashSet.add('l');
        linkedHashSet.add('e');
        System.out.println(linkedHashSet);

        TreeSet<Character> treeSet = new TreeSet<>();
        treeSet.add('a');
        treeSet.add('p');
        treeSet.add('p');
        treeSet.add('l');
        treeSet.add('e');
        System.out.println(treeSet);
    }
}
