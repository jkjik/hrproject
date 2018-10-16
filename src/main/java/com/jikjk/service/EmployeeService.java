package com.jikjk.service;

import com.jikjk.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface EmployeeService {
    //添加员工
    public void insert(Employee employee);
    //查看所有员工
    public List<Employee> selectAll();
    //通过eId查看员工
    public Employee SelectByEid(int eId);
    //修改
    public void updateAll(int eId, Employee employee);
    //修改职位
    public void updateDuty(int eId,int dId,String duty);
    //修改状态
    public void updateState(int eId,int eState);
    //查询本部门的下属员工
    public List<Employee> selectEmployee(int dId);
}
