package 基础内容.StringBuffer;

/**
 * StringBuffer()和StringBuilder()效率测试
 */
public class Case02 {
    public static long LEN = 10000000;
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        long time1 = System.currentTimeMillis();
        for(int i=0;i<LEN;i++) {
            stringBuffer.append(i);
        }
        long time2 = System.currentTimeMillis();
        long time3 = System.currentTimeMillis();
        for(int i=0;i<LEN;i++) {
            stringBuilder.append(i);
        }
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuffer用时："+(time2-time1));
        System.out.println("StringBuilder用时："+(time4-time3));
    }
}
