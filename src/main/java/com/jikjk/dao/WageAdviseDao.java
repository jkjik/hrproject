package com.jikjk.dao;

import com.jikjk.entity.WageAdvise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface WageAdviseDao {
    //添加工资复议
    public void insert(WageAdvise wageAdvise);
    //查询员工工资复议
    public WageAdvise selectByEid(int eId);
    //查看所有复议
    public List<WageAdvise> selectAll();
    //修改复议结果
    public void updateResult(int eId,String waResult);
}
