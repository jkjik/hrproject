package com.jikjk.service;

import com.jikjk.entity.WageAdvise;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface WageAdviseService {
    //添加工资复议
    public void insert(WageAdvise wageAdvise);
    //查询员工工资复议
    public WageAdvise selectByEid(int eId);
    //查看所有复议
    public List<WageAdvise> selectAll();
    //修改复议结果
    public void updateResult(String monthWorkTime,int eId,String waResult);
    //查询员工上个月复议工资
    public WageAdvise selectWageAdvise(String monthWorkTime,int eId);
    //查询未处理复议
    public List<WageAdvise> selectByResult(String waResult);
}
