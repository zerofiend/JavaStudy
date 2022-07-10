package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/*  提供增强功能的类    */
@Component
public class MyAspect {
    public void check() {
        System.out.println("检验身份信息");
    }

    public void callback() {
        System.out.println("显示写入数据是否成功");
    }

    public void backReturn(Object obj) {
        System.out.println(obj);
    }

    public void around(ProceedingJoinPoint point) throws Throwable { /*  point这个参数是需要被增强方法delete()的代理对象  */
        System.out.println("______之前增强操作");
        point.proceed();    /*  proceed相当于invoke方法，就是被执行的方法delete() */
        System.out.println("______之后增强操作");
    }

    public void around2(ProceedingJoinPoint point) throws Throwable { /*  point这个参数是需要被增强方法delete()的代理对象  */
        System.out.println("______之前增强操作");
        point.proceed();    /*  proceed相当于invoke方法，就是被执行的方法delete() */
        /*  获取被代理方法的形式参数    */
        Object[] args = point.getArgs();    /*  Object[] ---> [name,pwd]    */
        if (args != null && args.length == 2) {
            for (Object str : args) {
                System.out.println((String) str);
            }
        }
        System.out.println("______之后增强操作");
    }

    public void doException(Exception e) {
        System.out.println("抛出异常" + e);
    }

    public void afterFinally() {
        /*  开发中用于释放资源   */
        System.out.println("最终都会运行");
    }
}
