package com.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    /**
     * @param target 被代理的对象
     */
    public static Object getProxyBean(Object target) {
        /*  创建功能增强的对象（中介）   */
        MyAspect as = new MyAspect();
        /*  获取被代理的对象（房子的字节码对象）*/
        Class<?> c = target.getClass();
        /*  让中介和房子产生关系  */
        return Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 动态生成代理的代理对象
             *
             * @param method 目标方法（renting）的对象
             * @param args 接收 renting 方法中的参数
             * @return obj
             * @throws Throwable null
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                as.before();
                Object obj = method.invoke(target, args);/*  反射中执行方法：method对象.invoke(对象，args)    */
                as.after();
                return obj;
            }
        });
    }
}
