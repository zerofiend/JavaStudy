package proxy;

public class TestMessage {
    public static void main(String[] args) {
        Message message = new PostMessage();
        MessageProxy messageProxy = new MessageProxy(message);
        messageProxy.postMessage("Hello World");
    }
}
