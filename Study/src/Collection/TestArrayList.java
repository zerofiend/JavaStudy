package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * 去重
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student(1,"张三","男"));
        arrayList.add(new Student(2,"李四","男"));
        arrayList.add(new Student(2,"李四","男"));
        arrayList.add(new Student(3,"王五","男"));
        arrayList.add(new Student(3,"王五","男"));
        arrayList.add(new Student(3,"王五","男"));
        arrayList.add(new Student(3,"王五","男"));
        Iterator<Student> iterator = arrayList.iterator();
        ArrayList<Student> newArrayList = new ArrayList<>();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            if(!newArrayList.contains(student)) {
                newArrayList.add(student);
            }
        }
        System.out.println(newArrayList);

    }
}

class Student {
    private int id;
    private String name;
    private String gender;

    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }
}
