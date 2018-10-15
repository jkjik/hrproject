package com.jikjk.dao;

import com.jikjk.entity.SendResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/13.
 */
@Repository
public interface SendResumeDao {
    //创建发送简历
    public void insert(@Param("rId") int rId,@Param("uId") int uId);
    //查看发送简历状态（是否被观看）
    public SendResumeDao selectByUid(int uId);
    //通过简历rId修改查看状态
    public void updateReadState(@Param("rId") int rId, @Param("sStateRead") String sStateRead);
    //通过简历rId修改面试状态
    public void updateInformState(@Param("rId") int rId, @Param("sStateRead") String intvInform);
}
