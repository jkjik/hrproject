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
    //创建面试结果
    public void insert(InterviewResult interviewResult);
    //通过rId查找面试结果
    public InterviewResult selectByRid(int rId);
    //通过简历rId修改面试结果
    public void updateByRid(@Param("uId") int rId, @Param("iResult") String iResult);
    //查看所有的面试结果
    public List<InterviewResult> selectAll();
}
