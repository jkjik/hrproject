package com.jikjk.dao;

import com.jikjk.entity.PunishMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface PunishMoneyDao {
    //添加奖惩
    public void insert(PunishMoney punishMoney);
    //查询员工的奖惩
    public List<PunishMoney> selectPunishMoney(int eId);
    //查询所有
    public List<PunishMoney> selectAll();
    //修改奖惩
    public void updatePunish(PunishMoney punishMoney);
    //查询员工上个月奖惩工资
    public List<PunishMoney> selectMonthMoney(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
