package com.cglibproxy;


public class HouseOwner implements CglibProxyRent {
    @Override
    public void renting() {
        System.out.println("张三有一套房子出租");
    }

    @Override
    public void selling() {
        System.out.println("李四有一套房子要卖");
    }
}
