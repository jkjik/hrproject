package com.jikjk.service;

import com.jikjk.entity.BonusMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BonusMoneyService {
    //添加效绩奖金
    public void insert(BonusMoney bonusMoney);
    //查询员工的奖金
    public int selectBonus(int eId);
    //修改员工的奖金
    public void updateBonus(int eId,int boMoney);
    //查询当月的效绩奖金
    public List<BonusMoney> selectBonusMoney(String monthWorkTime, int eId);
}
