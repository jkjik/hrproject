package com.jikjk.service;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import com.jikjk.entity.utilpojo.ResSendResume;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface SendResumeService {
    //创建发送简历
    public void insert(int rId,int uId,Date sCreateTime);
    //查看发送简历状态（是否被观看）
    public List<SendResume> selectByUid(int uId);
    //通过简历rId修改查看状态
    public void updateReadState(int rId, String sStateRead);
    //通过简历rId修改面试状态
    public void updateInformState(int rId,String intvInform);
    //通过uId查看简历状态，带有简历
    public List<ResSendResume> selectResByUid(int uId);
}
