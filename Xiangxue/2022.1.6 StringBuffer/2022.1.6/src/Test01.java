/**
 * 学生类转StringBuffer
 */
public class Test01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(new Student("张三",18,"男"));
        System.out.println(sb);
    }
}
