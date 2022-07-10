package com.cglibproxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {
    /**
     * @param target 被代理的对象
     */
    public static Object getProxyBean(Object target) {
        /*  创建功能增强的对象（中介）   */
        MyAspect as = new MyAspect();
        /*  获取被代理的对象（房子的字节码对象）*/
        Class<?> c = target.getClass();
        /*  生成一个代理对象，这个代理对象是被代理对象的子类    */
        Enhancer enhancer = new Enhancer();
        /*  把被代理对象视为父类  */
        enhancer.setSuperclass(c);
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 动态生成代理的代理对象
             * @param method 目标方法（renting）的对象
             * @param objects 接收 renting 方法中的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                as.before();
                Object obj = method.invoke(target, objects);
                as.after();
                return obj;
            }
        });
        return enhancer.create();   //  返回了被代理对象
    }
}
