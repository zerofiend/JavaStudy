package com;

public class Student {
    @Override
    protected void finalize() throws Throwable {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("垃圾线程运行");
        }
    }
}
