package com.jikjk.service.impl;

import com.jikjk.dao.BonusMoneyDao;
import com.jikjk.entity.BonusMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class BonusMoneyService implements com.jikjk.service.BonusMoneyService{
    @Autowired
    private BonusMoneyDao bonusMoneyDao;

    public void insert(BonusMoney bonusMoney) {
        bonusMoneyDao.insert(bonusMoney);
    }

    public int selectBonus(int eId) {
        return bonusMoneyDao.selectBonus(eId);
    }

    public void updateBonus(int eId, int boMoney) {
        bonusMoneyDao.updateBonus(eId,boMoney);
    }
}
