package com.jikjk.dao;

import com.jikjk.entity.Department;
import com.jikjk.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface DepartmentDao {
    //查询所有部门
    public List<Department> selectAll();
    //通过dId查询部门
    public String selectNameByDid(int dId);
    //添加部门
    public void insert(Department department);
    //删除部门
    public void delete(int dId);
    //修改部门
    public void upadteDep(Department department);
    //查询部门
    public Department selectById(int dId);
    //通过部门名称查询部门
    public Department selectBydName(String dName);
}
