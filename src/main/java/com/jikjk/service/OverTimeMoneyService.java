package com.jikjk.service;

import com.jikjk.entity.OverTimeMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface OverTimeMoneyService {
    //添加加班工资
    public void insert(OverTimeMoney overTimeMoney);
    //查询员工的加班工资
    public int selectOverTime(int eId);
    //修改加班工资
    public void updateOverTime(int eId,int overTime);
    //查询所有
    public List<OverTimeMoney> selectAll();
}
