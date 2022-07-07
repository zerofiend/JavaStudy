package IO流.Demo04;

import java.io.*;

public class Demo04 {
    public static void main(String[] args) {
        Student student = new Student("张三",18,"男");
        Student student1 = new Student("1",18,"girl");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Study/src/IO流/Demo04/a.txt"))) {
            bufferedWriter.write(student.name);
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(student.age));
            bufferedWriter.newLine();
            bufferedWriter.write(student.gender);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Study/src/IO流/Demo04/b.txt"));
            objectOutputStream.writeObject(student1.toString());
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);        }
    }
}

class Student implements Serializable{
    String name;
    int age;
    String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
