package com.jikjk.service.impl;

import com.jikjk.dao.UserDao;
import com.jikjk.entity.User;
import com.jikjk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/11.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public User selectByUname(String uName) {
        return userDao.selectByUname(uName);
    }

    public User selectTologin(String uName, String uPassword) {
        return userDao.selectTologin(uName,uPassword);
    }
}
