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
    //创建面试
    public void insert(Interview interview);
    //通过id查询
    public Interview selectByIid(int iId);
    //通过rId查找
    public Interview selectByRid(int rId);
    //查询所有
    public List<Interview> selectAll();
    //修改
    public void updateByIid(@Param("iId") int iId,@Param("interview")Interview interview);
}
