package com.jikjk.service.impl;

import com.jikjk.dao.InterviewDao;
import com.jikjk.entity.Interview;
import com.jikjk.entity.InterviewResult;
import com.jikjk.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class InterviewServiceImpl implements InterviewService{
    @Autowired
    private InterviewDao interviewDao;
    public void insert(Interview interview) {
        interviewDao.insert(interview);
    }

    public Interview selectByIid(int iId) {
        return interviewDao.selectByIid(iId);
    }

    public Interview selectByRid(int rId) {
        return interviewDao.selectByRid(rId);
    }

    public List<Interview> selectAll() {
        return interviewDao.selectAll();
    }

    public void updateByIid(int iId, Interview interview) {
        interviewDao.updateByIid(iId,interview);
    }
}
