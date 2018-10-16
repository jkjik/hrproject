package com.jikjk.service.impl;

import com.jikjk.dao.BasicMoneyDao;
import com.jikjk.entity.BasicMoney;
import com.jikjk.service.BasicMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class BasicMoneyServiceImpl implements BasicMoneyService{
    @Autowired
    private BasicMoneyDao basicMoneyDao;

    public void insert(BasicMoney basicMoney) {
        basicMoneyDao.insert(basicMoney);
    }

    public int selectBasic(int eId) {
        return basicMoneyDao.selectBasic(eId);
    }

    public void updateBasic(int eId, int bMoney) {
        basicMoneyDao.updateBasic(eId,bMoney);
    }
}
