package com.jikjk.service.impl;

import com.jikjk.dao.WageAdviseDao;
import com.jikjk.entity.WageAdvise;
import com.jikjk.service.WageAdviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class WageAdviseServiceImpl implements WageAdviseService{
    @Autowired
    private WageAdviseDao wageAdviseDao;

    public void insert(WageAdvise wageAdvise) {
        wageAdviseDao.insert(wageAdvise);
    }

    public List<WageAdvise> selectByEid(int eId) {
        return wageAdviseDao.selectByEid(eId);
    }

    public List<WageAdvise> selectAll() {
        return wageAdviseDao.selectAll();
    }

    public void updateResult(String monthWorkTime, int eId, String waResult) {
        wageAdviseDao.updateResult(monthWorkTime,eId,waResult);
    }

    public WageAdvise selectWageAdvise(String monthWorkTime, int eId, String waResult) {
        return wageAdviseDao.selectWageAdvise(monthWorkTime,eId,waResult);
    }


    public List<WageAdvise> selectByResult(String waResult) {
        return wageAdviseDao.selectByResult(waResult);
    }
}
