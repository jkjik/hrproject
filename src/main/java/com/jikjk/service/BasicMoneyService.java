package com.jikjk.service;

import com.jikjk.entity.BasicMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BasicMoneyService {
    //��ӻ�������
    public void insert(BasicMoney basicMoney);
    //��ѯԱ���Ļ�������
    public BasicMoney selectBasic(int eId);
    //�޸Ļ�������
    public void updateBasic(int eId,int bMoney);
    //��ѯ���л�������
    public List<BasicMoney> selectAll();
}
