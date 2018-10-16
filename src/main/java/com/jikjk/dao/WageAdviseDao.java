package com.jikjk.dao;

import com.jikjk.entity.WageAdvise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface WageAdviseDao {
    //��ӹ��ʸ���
    public void insert(WageAdvise wageAdvise);
    //��ѯԱ�����ʸ���
    public WageAdvise selectByEid(int eId);
    //�鿴���и���
    public List<WageAdvise> selectAll();
    //�޸ĸ�����
    public void updateResult(int eId,String waResult);
}
