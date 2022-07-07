package Collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 自定义排序Student类对象
 */
public class Test03 {
    public static void main(String[] args) {
        TreeSet<Student2> treeSet = new TreeSet<>(new TestName());
        treeSet.add(new Student2("Alice",11));
        treeSet.add(new Student2("peter",13));
        treeSet.add(new Student2("paul",15));
        treeSet.add(new Student2("Ben",13));
        System.out.println(treeSet);
        TreeSet<Student2> treeSet1 = new TreeSet<>(new TestAge());
        treeSet1.addAll(treeSet);
        System.out.println(treeSet1);
    }
}


class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TestName implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class TestAge implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        if(o1.getAge() == o2.getAge()) return new TestName().compare(o1,o2);
        return o1.getAge() - o2.getAge();
    }
}
