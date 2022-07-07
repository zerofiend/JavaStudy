package com;

/**
 * Thread继承
 */
public class Demo02 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("线程一号正在运行——————————");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("线程二号正在运行----------");
        }
    }
}
