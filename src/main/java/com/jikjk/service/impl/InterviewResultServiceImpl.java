package com.jikjk.service.impl;

import com.jikjk.dao.InterviewDao;
import com.jikjk.dao.InterviewResultDao;
import com.jikjk.entity.Interview;
import com.jikjk.entity.InterviewResult;
import com.jikjk.service.InterviewResultService;
import com.jikjk.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class InterviewResultServiceImpl implements InterviewResultService {
    @Autowired
    private InterviewResultDao interviewResultDao;

    public void insert(InterviewResult interviewResult) {
        interviewResultDao.insert(interviewResult);
    }

    public InterviewResult selectByRid(int rId) {
        return interviewResultDao.selectByRid(rId);
    }

    public void updateByRid(int rId, String iResult) {
        interviewResultDao.updateByRid(rId,iResult);
    }

    public List<InterviewResult> selectAll() {
        return interviewResultDao.selectAll();
    }
}
