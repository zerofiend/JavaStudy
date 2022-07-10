package com.jdkstatic;

public class StarProxy implements StarBusiness {
    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }

    @Override
    public void face() {
        System.out.println("经纪人面谈");
    }

    @Override
    public void contract() {
        System.out.println("经纪人签约");
    }

    @Override
    public void orderPlane() {
        System.out.println("经纪人订机票");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void getMoney() {
        System.out.println("经纪人收款");
    }
}
