package com.jikjk.service.impl;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import com.jikjk.entity.utilpojo.ResSendResume;
import com.jikjk.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class SendResumeServiceImpl implements SendResumeService{
    @Autowired
    private SendResumeDao sendResumeDao;

    public void insert(int rId,int uId,Date sCreateTime) {
        sendResumeDao.insert(rId,uId,sCreateTime);
    }

    public List<SendResume> selectByUid(int uId) {
        return sendResumeDao.selectByUid(uId);
    }

    public void updateReadState(int rId, String sStateRead) {
        sendResumeDao.updateReadState(rId,sStateRead);
    }

    public void updateInformState(int rId, String intvInform) {
        sendResumeDao.updateInformState(rId,intvInform);
    }

    public List<ResSendResume> selectResByUid(int uId) {
        return sendResumeDao.selectResByUid(uId);
    }

}
