package 对象操作流;

import java.io.*;

/**
 * 序列化/反序列化
 */
public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*  普通写出    */
        User user = new User("root", "123");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/对象操作流/1.txt"));
        bufferedWriter.write(user.getUserName());
        bufferedWriter.newLine();
        bufferedWriter.write(user.getPassword());
        bufferedWriter.close();
        /*  序列化写出内容 */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/对象操作流/2.txt"));
        objectOutputStream.writeObject(user);
        /*  反序列化读取  */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/对象操作流/2.txt"));
        User read = (User) objectInputStream.readObject();
        System.out.println(read.getUserName());
        System.out.println(read.getPassword());
    }
}
