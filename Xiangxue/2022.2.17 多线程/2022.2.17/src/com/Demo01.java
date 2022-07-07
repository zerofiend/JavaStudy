package com;

/**
 * 模拟垃圾回收，体现多线程
 */
public class Demo01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            new Student();
            System.out.println("Main线程运行");
        }
    }
}
