package com.jikjk.dao;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface BasicMoneyDao {
    //添加基本工资
    public void insert(BasicMoney basicMoney);
    //查询员工的基本工资
    public int selectBasic(int eId);
    //修改基本工资
    public void updateBasic(@Param("eId") int eId, @Param("bMoney") int bMoney);
}

