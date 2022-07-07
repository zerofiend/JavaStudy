package com;

/**
 * 守护线程setDaemon()
 */
public class Demo06 {
    public static void main(String[] args) {
        ProThread thread1 = new ProThread();
        ProThread thread2 = new ProThread();
        thread1.setName("主");
        thread2.setName("守护");
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
    }
}

class ProThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程正在运行——————");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
