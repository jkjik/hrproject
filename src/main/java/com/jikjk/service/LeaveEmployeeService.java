package com.jikjk.service;

import com.jikjk.entity.LeaveEmployee;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */
public interface LeaveEmployeeService {
    //�����ְԱ��
    public void insert(LeaveEmployee leaveEmployee);
    //��ѯ������ְԱ��
    public List<LeaveEmployee> selectAll();
    //ͨ��eId��ѯ��ְԱ��
    public LeaveEmployee selectByEid(int eId);
}
