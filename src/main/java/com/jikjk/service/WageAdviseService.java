package com.jikjk.service;

import com.jikjk.entity.WageAdvise;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface WageAdviseService {
    //��ӹ��ʸ���
    public void insert(WageAdvise wageAdvise);
    //��ѯԱ�����ʸ���
    public WageAdvise selectByEid(int eId);
    //�鿴���и���
    public List<WageAdvise> selectAll();
    //�޸ĸ�����
    public void updateResult(int eId,String waResult);
}
