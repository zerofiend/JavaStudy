package proxy;

public class PostMessage implements Message {
    @Override
    public void postMessage(String msg) {
        System.out.println(msg);
    }
}
