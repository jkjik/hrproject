package com.jikjk.service;

import com.jikjk.entity.Wage;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface WageService {
    //��ӹ���
    public void insert(Wage wage);
    //ͨ��eId��ѯ����
    public Wage selectByEid(int eId);
    //�鿴����Ա���Ĺ���
    public List<Wage> selectAll();
}
