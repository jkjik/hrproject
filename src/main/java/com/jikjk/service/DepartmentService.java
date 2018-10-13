package com.jikjk.service;

import com.jikjk.entity.Department;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
public interface DepartmentService {
    //查询所有部门
    public List<Department> selectAll();
    //通过dId查询部门
    public String selectNameByDid(int dId);
}
