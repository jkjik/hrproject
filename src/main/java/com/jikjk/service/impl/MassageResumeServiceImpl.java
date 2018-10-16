package com.jikjk.service.impl;

import com.jikjk.dao.MassageResumeDao;
import com.jikjk.entity.MassageResume;
import com.jikjk.entity.utilpojo.ResMassageResume;
import com.jikjk.service.MassageResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class MassageResumeServiceImpl implements MassageResumeService{
    @Autowired
    private MassageResumeDao massageResumeDao;

    public void insert(MassageResume massageResume) {
        massageResumeDao.insert(massageResume);
    }

    public List<ResMassageResume> selectAll() {
        return massageResumeDao.selectAll();
    }

    public MassageResume selectByRid(int rId) {
        return massageResumeDao.selectByRid(rId);
    }

    public void updateStateRead(int rId, String stateRead) {
        massageResumeDao.updateStateRead(rId,stateRead);
    }

    public void updateStateInterview(int rId, String stateInterview) {
        massageResumeDao.updateStateInterview(rId,stateInterview);
    }

    public void delete(int rId) {
        massageResumeDao.delete(rId);
    }
}
