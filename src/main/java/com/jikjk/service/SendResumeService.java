package com.jikjk.service;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface SendResumeService {
    //创建发送简历
    public void insert(int rId,int uId);
    //查看发送简历状态（是否被观看）
    public SendResumeDao selectByUid(int uId);
    //通过简历rId修改查看状态
    public void updateReadState(int rId, String sStateRead);
    //通过简历rId修改面试状态
    public void updateInformState(int rId,String intvInform);
}
