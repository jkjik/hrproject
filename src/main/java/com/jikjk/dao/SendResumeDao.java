package com.jikjk.dao;

import com.jikjk.entity.SendResume;
import com.jikjk.entity.utilpojo.ResSendResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/13.
 */
@Repository
public interface SendResumeDao {
    //创建发送简历
    public void insert(@Param("rId") int rId, @Param("uId") int uId, @Param("sCreateTime")Date sCreateTime);
    //查看发送简历状态（是否被观看）
    public List<SendResume> selectByUid(int uId);
    //通过简历rId修改查看状态
    public void updateReadState(@Param("rId") int rId, @Param("sStateRead") String sStateRead);
    //通过简历rId修改面试状态
    public void updateInformState(@Param("rId") int rId, @Param("intvInform") String intvInform);
    //通过uId查看简历状态，带有简历
    public List<ResSendResume> selectResByUid(int uId);
}
