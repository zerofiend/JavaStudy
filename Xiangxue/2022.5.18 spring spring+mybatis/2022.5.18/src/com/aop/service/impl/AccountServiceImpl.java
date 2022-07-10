package com.aop.service.impl;

import com.aop.mapper.AccountMapper;
import com.aop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 对transfer进行业务增强，在转账之前检测账户余额是否充足
     *
     * @param out   转出账户的id
     * @param in    转入账号的id
     * @param money 转入的金额
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int transferAccount(int out, int in, int money) {
        /*  扣款  */
        int n1 = accountMapper.moneyOut(out, money);
        System.out.println(1 / 0);    //  模拟扣款成功进账失败
        /*  进账  */
        int n2 = accountMapper.moneyIn(in, money);
        if ((n1 + n2) == 2) {
            return 1;
        }
        return 0;
    }
}
