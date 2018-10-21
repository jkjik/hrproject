package com.jikjk.dao;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface BasicMoneyDao {
    //��ӻ�������
    public void insert(BasicMoney basicMoney);
    //��ѯԱ���Ļ�������
    public BasicMoney selectBasic(int eId);
    //�޸Ļ�������
    public void updateBasic(@Param("eId") int eId, @Param("bMoney") int bMoney);
    //��ѯ���л�������
    public List<BasicMoney> selectAll();
}

