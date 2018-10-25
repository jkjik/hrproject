package com.jikjk.dao;

import com.jikjk.entity.WageAdvise;
import org.apache.ibatis.annotations.Param;
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
    public List<WageAdvise> selectByEid(int eId);
    //查看所有复议
    public List<WageAdvise> selectAll();
    //修改复议结果
    public void updateResult(@Param("monthWorkTime") String monthWorkTime,@Param("eId") int eId,@Param("waResult") String waResult);
    //查询员工上个月复议工资
    public WageAdvise selectWageAdvise(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId,@Param("waResult") String waResult);
    //查询未处理复议
    public List<WageAdvise> selectByResult(String waResult);
}
