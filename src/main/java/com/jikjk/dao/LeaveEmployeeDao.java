package com.jikjk.dao;

import com.jikjk.entity.LeaveEmployee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */
@Repository
public interface LeaveEmployeeDao {
    //添加离职员工
    public void insert(LeaveEmployee leaveEmployee);
    //查询所有离职员工
    public List<LeaveEmployee> selectAll();
}
