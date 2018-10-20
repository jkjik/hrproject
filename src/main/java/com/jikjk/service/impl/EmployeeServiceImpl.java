package com.jikjk.service.impl;

import com.jikjk.dao.EmployeeDao;
import com.jikjk.entity.Employee;
import com.jikjk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    public Employee SelectByEid(int eId) {
        return employeeDao.SelectByEid(eId);
}

    public void updateAll(int eId, Employee employee) {
        employeeDao.updateAll(eId,employee);
    }

    public void updateDuty(int eId, int dId, String duty) {
        employeeDao.updateDuty(eId,dId,duty);
    }

    public void updateState(int eId, int eState) {
        employeeDao.updateState(eId,eState);
    }

    public List<Employee> selectEmployee(int dId) {
        return employeeDao.selectEmployee(dId);
    }

    public Employee selectByUid(int uId) {
        return employeeDao.selectByUid(uId);
    }

    public List<Employee> selectByDuty(String duty) {
        return employeeDao.selectByDuty(duty);
    }
}
