package com;

/**
 * 加入线程join()
 * 礼让线程yield()
 * 设置优先级
 */
public class Demo07 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("1线程加入运行");
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("1线程正在运行");
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("2线程正在运行");
                    if (i == 50) {
/*                        try {
                            thread1.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }*/
                        Thread.yield(); //  礼让线程
                    }
                }
            }
        };
        thread1.setPriority(1);
        thread2.setPriority(10);
        thread2.start();
        thread1.start();
    }
}
