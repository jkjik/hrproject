package com.jikjk.service.impl;

import com.jikjk.dao.OverTimeMoneyDao;
import com.jikjk.entity.OverTimeMoney;
import com.jikjk.service.OverTimeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class OverTimeMoneyServiceImpl implements OverTimeMoneyService{
    @Autowired
    private OverTimeMoneyDao overTimeMoneyDao;

    public void insert(OverTimeMoney overTimeMoney) {
        overTimeMoneyDao.insert(overTimeMoney);
    }

    public void updateOverTime(int eId, int overTime) {
        overTimeMoneyDao.updateOverTime(eId,overTime);
    }

    public List<OverTimeMoney> selectAll() {
        return overTimeMoneyDao.selectAll();
    }

    public List<OverTimeMoney> selectOverMoney(String monthWorkTime, int eId) {
        return overTimeMoneyDao.selectOverMoney(monthWorkTime,eId);
    }
}
