package more;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class Demo03 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.shutdown();
    }
}

class TestThread extends Thread {
    Random random = new Random();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(1001);
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "线程运行了第" + (i + 1) + "次");
        }
    }
}
