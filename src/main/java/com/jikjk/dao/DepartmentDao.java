package com.jikjk.dao;

import com.jikjk.entity.Department;
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
}
