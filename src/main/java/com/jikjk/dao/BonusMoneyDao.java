package com.jikjk.dao;

import com.jikjk.entity.BonusMoney;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface BonusMoneyDao {
    //���Ч������
    public void insert(BonusMoney bonusMoney);
    //��ѯԱ���Ľ���
    public int selectBonus(int eId);
    //�޸�Ա���Ľ���
    public void updateBonus(int eId,int boMoney);
}
