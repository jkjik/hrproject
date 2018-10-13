package com.jikjk.service.impl;

import com.jikjk.dao.DepartmentDao;
import com.jikjk.entity.Department;
import com.jikjk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Service
public class DepartmetServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    //查询所有部门
    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }
    //通过dId查询部门
    public String selectDnameByDid(int dId) {
        return departmentDao.selectNameByDid(dId);
    }
}
