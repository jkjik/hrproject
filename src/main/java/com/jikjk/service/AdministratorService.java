package com.jikjk.service;

import com.jikjk.entity.Administrator;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface AdministratorService {
    //��������Ա
    public void insert(Administrator administrator);
    //ɾ������Ա
    public void delete(int aId);
    //��������
    public void selectAll();
    //ͨ��uId���ҹ���Ա
    public Administrator selectByUid(int uId);
    //ͨ�����ֲ��ҹ���Ա
    public Administrator selectByName(int aName);
}