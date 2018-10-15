package com.jikjk.dao;

import com.jikjk.entity.InterviewResult;
import com.jikjk.entity.MassageResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface InterviewResultDao {
    //�������Խ��
    public void insert(InterviewResult interviewResult);
    //ͨ��rId�������Խ��
    public InterviewResult selectByRid(int rId);
    //ͨ������rId�޸����Խ��
    public void updateByRid(@Param("uId") int rId, @Param("iResult") String iResult);
    //�鿴���е����Խ��
    public List<InterviewResult> selectAll();
}
