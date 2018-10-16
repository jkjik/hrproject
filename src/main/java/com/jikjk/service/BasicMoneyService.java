package com.jikjk.service;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BasicMoneyService {
    //添加基本工资
    public void insert(BasicMoney basicMoney);
    //查询员工的基本工资
    public int selectBasic(int eId);
    //修改基本工资
    public void updateBasic(int eId,int bMoney);
}
