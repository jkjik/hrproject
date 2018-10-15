package com.jikjk.service.impl;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import com.jikjk.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class SendResumeServiceImpl implements SendResumeService{
    @Autowired
    private SendResumeDao sendResumeDao;

    public void insert(int rId,int uId) {
        sendResumeDao.insert(rId,uId);
    }

    public SendResumeDao selectByUid(int uId) {
        return sendResumeDao.selectByUid(uId);
    }

    public void updateReadState(int rId, String sStateRead) {
        sendResumeDao.updateReadState(rId,sStateRead);
    }

    public void updateInformState(int rId, String intvInform) {
        sendResumeDao.updateInformState(rId,intvInform);
    }

}
