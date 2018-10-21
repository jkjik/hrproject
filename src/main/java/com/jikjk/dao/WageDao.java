package com.jikjk.dao;

import com.jikjk.entity.Wage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface WageDao {
    //��ӹ���
    public void insert(Wage wage);
    //ͨ��eId��ѯ����
    public List<Wage> selectByEid(int eId);
    //�鿴����Ա���Ĺ���
    public List<Wage> selectAll();
    //�鿴Ա�����µĹ���
    public Wage selectWage(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId);
}
