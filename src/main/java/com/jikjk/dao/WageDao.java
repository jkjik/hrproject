package com.jikjk.dao;

import com.jikjk.entity.Wage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface WageDao {
    //添加工资
    public void insert(Wage wage);
    //通过eId查询工资
    public Wage selectByEid(int eId);
    //查看所有员工的工资
    public List<Wage> selectAll();
}
