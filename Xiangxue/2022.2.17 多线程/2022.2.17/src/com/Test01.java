package com;

/**
 * 买票模拟
 */
public class Test01 {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread thread1 = new Thread("黄牛") {
            @Override
            public void run() {
                while (true) {
                    tickets.sell();
                }
            }
        };
        Thread thread2 = new Thread("顾客") {
            @Override
            public void run() {
                while (true) {
                    tickets.sell();
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}

class Tickets {
    private int tickets = 50;

    public synchronized void sell() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "买到了第" + (tickets--) + "张票");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
