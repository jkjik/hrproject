package com.jikjk.dao;

import com.jikjk.entity.Wage;
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
    public Wage selectByEid(int eId);
    //�鿴����Ա���Ĺ���
    public List<Wage> selectAll();
}
