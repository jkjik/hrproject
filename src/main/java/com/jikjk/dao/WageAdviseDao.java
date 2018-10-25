package com.jikjk.dao;

import com.jikjk.entity.WageAdvise;
import org.apache.ibatis.annotations.Param;
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
    public List<WageAdvise> selectByEid(int eId);
    //�鿴���и���
    public List<WageAdvise> selectAll();
    //�޸ĸ�����
    public void updateResult(@Param("monthWorkTime") String monthWorkTime,@Param("eId") int eId,@Param("waResult") String waResult);
    //��ѯԱ���ϸ��¸��鹤��
    public WageAdvise selectWageAdvise(@Param("monthWorkTime")String monthWorkTime, @Param("eId")int eId,@Param("waResult") String waResult);
    //��ѯδ������
    public List<WageAdvise> selectByResult(String waResult);
}
