package more;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer类   计时器
 */
public class Demo01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), new Date(System.currentTimeMillis() + 5000), 1000);
    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("正在工作");
    }
}