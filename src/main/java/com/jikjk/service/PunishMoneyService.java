package com.jikjk.service;

import com.jikjk.entity.OverTimeMoney;
import com.jikjk.entity.PunishMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface PunishMoneyService {
    //���ӽ���
    public void insert(PunishMoney punishMoney);
    //��ѯԱ���Ľ���
    public PunishMoney selectPunishMoney(int eId);
    //��ѯ����
    public List<PunishMoney> selectAll();
    //�޸Ľ���
    public void updatePunish(PunishMoney punishMoney);
}