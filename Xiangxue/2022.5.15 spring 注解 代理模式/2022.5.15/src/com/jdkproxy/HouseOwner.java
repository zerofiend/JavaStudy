package com.jdkproxy;

public class HouseOwner implements JdkProxyRent {
    @Override
    public void renting() {
        System.out.println("张三有一套房子出租");
    }

    @Override
    public void selling() {
        System.out.println("李四有一套房子要卖");
    }
}
