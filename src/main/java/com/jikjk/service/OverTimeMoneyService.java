package com.jikjk.service;

import com.jikjk.entity.OverTimeMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface OverTimeMoneyService {
    //��ӼӰ๤��
    public void insert(OverTimeMoney overTimeMoney);
    //�޸ļӰ๤��
    public void updateOverTime(int eId,int overTime);
    //��ѯ����
    public List<OverTimeMoney> selectAll();
    //��ѯԱ���ļӰ๤��
    public List<OverTimeMoney> selectOverMoney(String monthWorkTime,int eId);
}
