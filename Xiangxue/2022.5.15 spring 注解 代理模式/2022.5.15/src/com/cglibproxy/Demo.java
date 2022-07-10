package com.cglibproxy;

public class Demo {
    public static void main(String[] args) {
        HouseOwner owner = new HouseOwner();
        CglibProxyRent zhongJie = (CglibProxyRent) CglibProxyFactory.getProxyBean(owner);
        zhongJie.renting();
        zhongJie.selling();
    }
}
