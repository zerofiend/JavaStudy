package com.aop.mapper;

import com.aop.pojo.Account;
import com.aop.pojo.AccountExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    @Update("update account set money = money - #{param2} where aid = #{param1}")
    int moneyOut(int aid, int money);

    @Update("update account set money = money + #{param2} where aid = #{param1}")
    int moneyIn(int aid, int money);
}
