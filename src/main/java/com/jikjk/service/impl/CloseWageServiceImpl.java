package com.jikjk.service.impl;

import com.jikjk.dao.CloseWageDao;
import com.jikjk.entity.CloseWage;
import com.jikjk.service.CloseWageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/21.
 */
@Service
public class CloseWageServiceImpl implements CloseWageService{
    @Autowired
    private CloseWageDao closeWageDao;
    public void insert(CloseWage closeWage) {
        closeWageDao.insert(closeWage);
    }

    public CloseWage selectCloseWage(String monthWorkTime, int eId) {
        return closeWageDao.selectCloseWage(monthWorkTime,eId);
    }
}
