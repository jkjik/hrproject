package com.jikjk.dao;

import com.jikjk.entity.CloseWage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/21.
 */
@Repository
public interface CloseWageDao {
    //��ӹ��ʽ���
    public void insert(CloseWage closeWage);
    //��ѯ�ϸ���Ա���Ľ��㹤��
    public CloseWage selectCloseWage(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
