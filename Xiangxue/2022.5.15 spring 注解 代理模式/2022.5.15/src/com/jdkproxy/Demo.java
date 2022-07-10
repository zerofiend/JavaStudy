package com.jdkproxy;

public class Demo {
    public static void main(String[] args) {
        JdkProxyRent owner = new HouseOwner();
        /*  创建代理对象  */
        JdkProxyRent zhongJie = (JdkProxyRent) JdkProxyFactory.getProxyBean(owner);
        zhongJie.renting();
        zhongJie.selling();
    }
}
