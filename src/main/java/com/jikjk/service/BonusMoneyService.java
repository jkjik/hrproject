package com.jikjk.service;

import com.jikjk.entity.BonusMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BonusMoneyService {
    //���Ч������
    public void insert(BonusMoney bonusMoney);
    //��ѯԱ���Ľ���
    public int selectBonus(int eId);
    //�޸�Ա���Ľ���
    public void updateBonus(int eId,int boMoney);
    //��ѯ���µ�Ч������
    public List<BonusMoney> selectBonusMoney(String monthWorkTime, int eId);
}
