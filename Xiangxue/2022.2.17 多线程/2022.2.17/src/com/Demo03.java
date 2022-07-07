package com;

/**
 * 实现Runnable接口
 */
public class Demo03 {
    public static void main(String[] args) {
        My1 my1 = new My1();
        Thread thread1 = new Thread(my1);
        My2 my2 = new My2();
        Thread thread2 = new Thread(my2);
        thread1.start();
        thread2.start();
    }
}

class My1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("一号线程正在运行——————————");
        }
    }
}

class My2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("二号线程正在运行----------");
        }
    }
}
