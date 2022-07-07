package com;

/**
 * 设置线程名称
 * 线程休眠sleep()
 * currentThread()方法可以获取当前线程对象
 */
public class Demo05 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
//                    System.out.println("三号线程正在运行-——-——-——-");
                    System.out.println(Thread.currentThread().getName() + "线程正在运行——————————");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
//                    System.out.println("四号线程正在运行_-_-_-_-_-");
                    System.out.println(Thread.currentThread().getName() + "线程正在运行----------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.setName("一号线程");
        thread2.setName("二号线程");
        thread1.start();
        thread2.start();
    }
}
