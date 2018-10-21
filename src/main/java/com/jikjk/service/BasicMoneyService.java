package com.jikjk.service;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BasicMoneyService {
    //添加基本工资
    public void insert(BasicMoney basicMoney);
    //查询员工的基本工资
    public BasicMoney selectBasic(int eId);
    //修改基本工资
    public void updateBasic(int eId,int bMoney);
    //查询所有基本工资
    public List<BasicMoney> selectAll();
}
