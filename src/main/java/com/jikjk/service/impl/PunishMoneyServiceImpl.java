package com.jikjk.service.impl;

import com.jikjk.dao.PunishMoneyDao;
import com.jikjk.entity.OverTimeMoney;
import com.jikjk.entity.PunishMoney;
import com.jikjk.service.PunishMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class PunishMoneyServiceImpl implements PunishMoneyService{
    @Autowired
    private PunishMoneyDao punishMoneyDao;

    public void insert(PunishMoney punishMoney) {
        punishMoneyDao.insert(punishMoney);
    }

    public List<PunishMoney> selectPunishMoney(int eId) {
        return punishMoneyDao.selectPunishMoney(eId);
    }

    public List<PunishMoney> selectAll() {
        return punishMoneyDao.selectAll();
    }

    public void updatePunish(PunishMoney punishMoney) {
        punishMoneyDao.updatePunish(punishMoney);
    }
}
