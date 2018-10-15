package com.jikjk.dao;

import com.jikjk.entity.Administrator;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface AdministratorDao {
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
