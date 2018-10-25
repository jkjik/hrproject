package com.jikjk.service;

import com.jikjk.entity.PunishMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface PunishMoneyService {
    //添加奖惩
    public void insert(PunishMoney punishMoney);
    //查询员工的奖惩
    public List<PunishMoney> selectPunishMoney(int eId);
    //查询所有
    public List<PunishMoney> selectAll();
    //修改奖惩
    public void updatePunish(PunishMoney punishMoney);
    //查询员工上个月奖惩工资
    public List<PunishMoney> selectMonthMoney(String monthWorkTime,int eId);
}
