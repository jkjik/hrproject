package com.jikjk.service;

import com.jikjk.entity.OverTimeMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface OverTimeMoneyService {
    //��ӼӰ๤��
    public void insert(OverTimeMoney overTimeMoney);
    //��ѯԱ���ļӰ๤��
    public int selectOverTime(int eId);
    //�޸ļӰ๤��
    public void updateOverTime(int eId,int overTime);
    //��ѯ����
    public List<OverTimeMoney> selectAll();
}
