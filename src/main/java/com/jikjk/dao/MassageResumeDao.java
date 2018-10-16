package com.jikjk.dao;

import com.jikjk.entity.MassageResume;
import com.jikjk.entity.utilpojo.ResMassageResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface MassageResumeDao {
    //创建简历信息
    public void insert(MassageResume massageResume);
    //查看所有简历状态
    public List<ResMassageResume> selectAll();
    //查看简历状态（是否被观看,面试）
    public MassageResume selectByRid(int rId);
    //通过简历rId修改查看状态
    public void updateStateRead(@Param("rId") int rId, @Param("stateRead") String stateRead);
    //通过简历rId修改面试状态
    public void updateStateInterview(@Param("rId") int rId, @Param("stateRead") String stateInterview);
    //删除
    public void delete(int rId);
}
