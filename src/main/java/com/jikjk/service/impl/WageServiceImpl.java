package com.jikjk.service.impl;

import com.jikjk.dao.WageDao;
import com.jikjk.entity.Wage;
import com.jikjk.entity.WageAdvise;
import com.jikjk.service.WageAdviseService;
import com.jikjk.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class WageServiceImpl implements WageService {
    @Autowired
    private WageDao wageDao;

    public void insert(Wage wage) {
        wageDao.insert(wage);
    }

    public List<Wage> selectByEid(int eId) {
        return wageDao.selectByEid(eId);
    }

    public List<Wage> selectAll() {
        return wageDao.selectAll();
    }

    public Wage selectWage(String monthWorkTime, int eId) {
        return wageDao.selectWage(monthWorkTime,eId);
    }
}
