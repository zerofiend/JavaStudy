package 基础内容.Object;

public class TestCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample cloneExample = new CloneExample(1,2);
        CloneExample clone = (CloneExample) cloneExample.clone();
        System.out.println(clone.toString());
    }
}
