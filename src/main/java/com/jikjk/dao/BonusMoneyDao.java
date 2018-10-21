package com.jikjk.dao;

import com.jikjk.entity.BonusMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface BonusMoneyDao {
    //添加效绩奖金
    public void insert(BonusMoney bonusMoney);
    //查询员工的奖金
    public int selectBonus(int eId);
    //修改员工的奖金
    public void updateBonus(int eId,int boMoney);
    //查询当月的效绩奖金
    public List<BonusMoney> selectBonusMoney(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
