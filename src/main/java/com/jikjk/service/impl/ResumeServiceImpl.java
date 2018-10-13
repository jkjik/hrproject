package com.jikjk.service.impl;

import com.jikjk.dao.ResumeDao;
import com.jikjk.entity.Resume;
import com.jikjk.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/10/13.
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Autowired
    private ResumeDao resumeDao;

    public void insert(Resume resume) {
        resumeDao.insert(resume);
    }

    public Resume selectByUid(int uId) {
        return resumeDao.selectByUid(uId);
    }
}
