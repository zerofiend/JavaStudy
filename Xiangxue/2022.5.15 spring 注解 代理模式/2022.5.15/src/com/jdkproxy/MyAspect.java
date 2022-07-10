package com.jdkproxy;

/*
 *   房产中介
 * */
public class MyAspect {
    /*  出租之前    */
    public void before() {
        System.out.println("带客户看房子");
    }

    /*  出租之后    */
    public void after() {
        System.out.println("辅助完成房子签约的服务");
    }
}
