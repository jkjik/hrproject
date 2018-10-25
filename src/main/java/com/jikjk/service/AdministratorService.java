package com.jikjk.service;

import com.jikjk.entity.Administrator;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface AdministratorService {
    //创建管理员
    public void insert(Administrator administrator);
    //删除管理员
    public void delete(int aId);
    //查找所有
    public List<Administrator> selectAll();
    //通过uId查找管理员
    public Administrator selectByUid(int uId);
    //通过名字查找管理员
    public Administrator selectByName(int aName);
}
