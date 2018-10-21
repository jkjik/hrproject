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
    //��ӽ���
    public void insert(PunishMoney punishMoney);
    //��ѯԱ���Ľ���
    public List<PunishMoney> selectPunishMoney(int eId);
    //��ѯ����
    public List<PunishMoney> selectAll();
    //�޸Ľ���
    public void updatePunish(PunishMoney punishMoney);
    //��ѯԱ���ϸ��½��͹���
    public List<PunishMoney> selectMonthMoney(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
