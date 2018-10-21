package com.jikjk.service.impl;

import com.jikjk.dao.LeaveEmployeeDao;
import com.jikjk.entity.LeaveEmployee;
import com.jikjk.service.LeaveEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */
@Service
public class LeaveEmployeeServiceImpl implements LeaveEmployeeService{
    @Autowired
    private LeaveEmployeeDao leaveEmployeeDao;

    public void insert(LeaveEmployee leaveEmployee) {
        leaveEmployeeDao.insert(leaveEmployee);
    }

    public List<LeaveEmployee> selectAll() {
        return leaveEmployeeDao.selectAll();
    }
}
