package com.jikjk.dao;

import com.jikjk.entity.Interview;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface InterviewDao {
    //��������
    public void insert(Interview interview);
    //ͨ��id��ѯ
    public Interview selectByIid(int iId);
    //ͨ��rId����
    public Interview selectByRid(int rId);
    //��ѯ����
    public List<Interview> selectAll();
    //�޸�
    public void updateByIid(@Param("iId") int iId,@Param("interview")Interview interview);
}
