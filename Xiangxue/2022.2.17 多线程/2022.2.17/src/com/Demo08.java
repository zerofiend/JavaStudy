package com;

/**
 * 同步代码块
 */
public class Demo08 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Test.show();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Test.tell();
                }
            }
        }.start();

    }
}

class Test {
    private static final String s = "";

    public static void show() {
        synchronized (s) {
            System.out.println("apple");
        }
    }

    public static void tell() {
        synchronized (s) {
            System.out.println("banana");
        }
    }
}
