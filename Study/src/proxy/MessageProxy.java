package proxy;

public class MessageProxy implements Message {
    private final Message message;

    public MessageProxy(Message message) {
        this.message = message;
    }

    @Override
    public void postMessage(String msg) {
        System.out.println("代理前内容");
        message.postMessage(msg);
        System.out.println("代理后内容");
    }
}
