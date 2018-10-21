package com.jikjk.dao;

import com.jikjk.entity.OverTimeMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface OverTimeMoneyDao {
    //添加加班工资
    public void insert(OverTimeMoney overTimeMoney);
    //修改加班工资
    public void updateOverTime(@Param("eId") int eId,@Param("OverTime") int overTime);
    //查询所有
    public List<OverTimeMoney> selectAll();
    //查询员工的加班工资
    public List<OverTimeMoney> selectOverMoney(@Param("monthWorkTime")String monthWorkTime,@Param("eId")int eId);
}
