package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*  提供增强功能的类    */
@Component
@Aspect //  这个注解表示告诉spring容器，当前是切面类
public class MyAspect {
    @Before(value = "execution(* com.aop.service.impl.UserServiceImpl.save(..))")
    public void check() {
        System.out.println("检验身份信息");
    }

    @AfterReturning(value = "execution(* com.aop.service.impl.UserServiceImpl.save(..))")
    public void callback() {
        System.out.println("显示写入数据是否成功");
    }

    @AfterReturning(value = "execution(* com.aop.service.impl.UserServiceImpl.saveBack(..))", returning = "obj")
    public void backReturn(Object obj) {
        System.out.println(obj);
    }

    @Around(value = "execution(* com.aop.service.impl.UserServiceImpl.delete(..))")
    public void around(ProceedingJoinPoint point) throws Throwable { /*  point这个参数是需要被增强方法delete()的代理对象  */
        System.out.println("______之前增强操作");
        point.proceed();    /*  proceed相当于invoke方法，就是被执行的方法delete() */
        System.out.println("______之后增强操作");
    }

    @Around(value = "execution(* com.aop.service.impl.UserServiceImpl.delete2(..))")
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

    @AfterThrowing(value = "execution(* com.aop.service.impl.UserServiceImpl.update(..))", throwing = "e")
    public void doException(Exception e) {
        System.out.println("抛出异常" + e);
    }

    @After(value = "execution(* com.aop.service.impl.UserServiceImpl.update(..))")
    public void afterFinally() {
        /*  开发中用于释放资源   */
        System.out.println("最终都会运行");
    }
}
