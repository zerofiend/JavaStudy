package com;

/**
 * 匿名内部类的使用
 */
public class Demo04 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    System.out.println("一号线程正在运行——————————");
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    System.out.println("二号线程正在运行----------");
                }
            }
        }.start();
    }
}
