package com.jikjk.service;

import com.jikjk.entity.InterviewResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface InterviewResultService {
    //创建面试结果
    public void insert(InterviewResult interviewResult);
    //通过rId查找面试结果
    public InterviewResult selectByRid(int rId);
    //通过简历rId修改面试结果
    public void updateByRid(@Param("uId") int rId, @Param("iResult") String iResult);
    //查看所有的面试结果
    public List<InterviewResult> selectAll();
}
