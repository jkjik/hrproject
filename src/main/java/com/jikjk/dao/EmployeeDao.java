package com.jikjk.dao;

import com.jikjk.entity.Employee;
import com.jikjk.entity.utilpojo.ResWage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface EmployeeDao {
    //添加员工
    public void insert(Employee employee);
    //查看所有员工
    public List<Employee> selectAll();
    //通过eId查看员工
    public Employee SelectByEid(int eId);
    //修改
    public void updateAll(@Param("eId") int eId, @Param("employee") Employee employee);
    //修改职位
    public void updateDuty(@Param("eId") int eId,@Param("dId") int dId,@Param("duty") String duty);
    //修改状态
    public void updateState(@Param("eId") int eId,@Param("eState") int eState);
    //查询本部门的下属员工
    public List<Employee> selectEmployee(int dId);
    //通过uId查找员工
    public Employee selectByUid(int uId);
    //通过职位名称查询员工
    public List<Employee> selectByDuty(String duty);
    //查询所有的员工基本工资社保
    public List<ResWage> selectAllResWage();
}
