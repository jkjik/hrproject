package com.jikjk.dao;

import com.jikjk.entity.CloseWage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/21.
 */
@Repository
public interface CloseWageDao {
    //添加工资结算
    public void insert(CloseWage closeWage);
    //查询上个月员工的结算工资
    public CloseWage selectCloseWage(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
