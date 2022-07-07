package com;

/**
 * 死锁
 */
public class Demo09 {
    public static void main(String[] args) {
        String s1 = "碗";
        String s2 = "筷子";
        Thread t1 = new Thread("张三") {
            @Override
            public void run() {
                synchronized (s1) {
                    System.out.println(Thread.currentThread().getName() + "抢到了" + s1);
                    synchronized (s2) {
                        System.out.println("再拿到" + s2 + "就可以吃饭");
                    }
                }
            }
        };
        Thread t2 = new Thread("李四") {
            @Override
            public void run() {
                synchronized (s2) {
                    System.out.println(Thread.currentThread().getName() + "抢到了" + s2);
                    synchronized (s1) {
                        System.out.println("再拿到" + s1 + "就可以吃饭");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
