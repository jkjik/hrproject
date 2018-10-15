package com.jikjk.service;

import com.jikjk.entity.InterviewResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface InterviewResultService {
    //�������Խ��
    public void insert(InterviewResult interviewResult);
    //ͨ��rId�������Խ��
    public InterviewResult selectByRid(int rId);
    //ͨ������rId�޸����Խ��
    public void updateByRid(@Param("uId") int rId, @Param("iResult") String iResult);
    //�鿴���е����Խ��
    public List<InterviewResult> selectAll();
}
