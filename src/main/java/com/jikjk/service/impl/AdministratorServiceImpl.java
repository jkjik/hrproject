package com.jikjk.service.impl;

import com.jikjk.dao.AdministratorDao;
import com.jikjk.entity.Administrator;
import com.jikjk.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class AdministratorServiceImpl implements AdministratorService{
    @Autowired
    private AdministratorDao administratorDao;

    public void insert(Administrator administrator) {
        administratorDao.insert(administrator);
    }

    public void delete(int aId) {
        administratorDao.delete(aId);
    }

    public void selectAll() {
        administratorDao.selectAll();
    }

    public Administrator selectByUid(int uId) {
        return administratorDao.selectByUid(uId);
    }

    public Administrator selectByName(int aName) {
        return administratorDao.selectByName(aName);
    }
}
