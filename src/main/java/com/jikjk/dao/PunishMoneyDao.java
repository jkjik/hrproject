package com.jikjk.dao;

import com.jikjk.entity.PunishMoney;
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
    public PunishMoney selectPunishMoney(int eId);
    //��ѯ����
    public List<PunishMoney> selectAll();
    //�޸Ľ���
    public void updatePunish(PunishMoney punishMoney);
}
