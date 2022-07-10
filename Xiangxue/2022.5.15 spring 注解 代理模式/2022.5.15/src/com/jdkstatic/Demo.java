package com.jdkstatic;

/*
 *   静态代理模式
 * */
public class Demo {
    public static void main(String[] args) {
        Star star = new Star();
        StarProxy starProxy = new StarProxy(star);
        starProxy.face();
        starProxy.contract();
        starProxy.orderPlane();
        starProxy.sing();
        starProxy.getMoney();
    }
}
