package 对象操作流;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 存入多个对象
 */
public class Demo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user1 = new User("张三", "123");
        User user2 = new User("李四", "123");
        User user3 = new User("王五", "123");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/对象操作流/3.txt"));
        objectOutputStream.writeObject(list);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/对象操作流/3.txt"));
        ArrayList<User> ans = (ArrayList) objectInputStream.readObject();
        for (User user : ans) {
            System.out.println(user);
        }
    }
}
