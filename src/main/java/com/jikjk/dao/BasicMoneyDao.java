package com.jikjk.dao;

import com.jikjk.entity.BasicMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface BasicMoneyDao {
    //��ӻ�������
    public void insert(BasicMoney basicMoney);
    //��ѯԱ���Ļ�������
    public int selectBasic(int eId);
    //�޸Ļ�������
    public void updateBasic(@Param("eId") int eId, @Param("bMoney") int bMoney);
}

