package com.jikjk.service;

import com.jikjk.entity.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface InterviewService {
    //创建面试
    public void insert(Interview interview);
    //通过id查询
    public Interview selectByIid(int iId);
    //通过rId查找
    public Interview selectByRid(int rId);
    //查询所有
    public List<Interview> selectAll();
    //修改
    public void updateByIid(@Param("iId") int iId, @Param("interview")Interview interview);
}
