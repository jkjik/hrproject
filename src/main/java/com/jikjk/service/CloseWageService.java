package com.jikjk.service;

import com.jikjk.entity.CloseWage;

/**
 * Created by lenovo on 2018/10/21.
 */
public interface CloseWageService {
    //添加工资结算
    public void insert(CloseWage closeWage);
    //查询上个月员工的结算工资
    public CloseWage selectCloseWage(String monthWorkTime, int eId);
}
