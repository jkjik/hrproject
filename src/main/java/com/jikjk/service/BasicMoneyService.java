package com.jikjk.service;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface BasicMoneyService {
    //��ӻ�������
    public void insert(BasicMoney basicMoney);
    //��ѯԱ���Ļ�������
    public int selectBasic(int eId);
    //�޸Ļ�������
    public void updateBasic(int eId,int bMoney);
}
