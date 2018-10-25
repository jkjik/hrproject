package com.jikjk.service;

import com.jikjk.entity.LeaveEmployee;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */
public interface LeaveEmployeeService {
    //添加离职员工
    public void insert(LeaveEmployee leaveEmployee);
    //查询所有离职员工
    public List<LeaveEmployee> selectAll();
    //通过eId查询离职员工
    public LeaveEmployee selectByEid(int eId);
}
