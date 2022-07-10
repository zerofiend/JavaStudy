package com.aop.aspect;

import com.aop.mapper.AccountMapper;
import com.aop.pojo.Account;
import com.aop.selfexception.MoneyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @param point 是transferAccount 方法的代理对象
     */
    @Around(value = "execution(* com.aop.service.impl.AccountServiceImpl.transferAccount(..))")
    public void checkMoney(ProceedingJoinPoint point) throws Throwable {
//        转账前执行
        /*  获取方法中的参数列表  */
        Object[] args = point.getArgs();
        /*  接收id    */
        int out = (int) args[0];
        int money = (int) args[2];
        /*  检测余额    */
        Account account = accountMapper.selectByPrimaryKey(out);
        int balance = account.getMoney();
        int n = balance - money;
//        转账时执行
        if (n >= 0) {
            point.proceed();    /*  代表让方法继续执行   */
        } else {
            throw new MoneyException("余额不足");
        }
//    转账后执行
        System.out.println("转账成功");
    }

}
