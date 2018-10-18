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
    public String selectNameByDid(int dId) {
        return departmentDao.selectNameByDid(dId);
    }

    public void insert(Department department) {
        departmentDao.insert(department);
    }

    public void delete(int dId) {
        departmentDao.delete(dId);
    }

    public void upadteDep(Department department) {
        departmentDao.upadteDep(department);
    }

    public Department selectById(int dId) {
        return departmentDao.selectById(dId);
    }

    public Department selectBydName(String dName) {
        return departmentDao.selectBydName(dName);
    }
}
