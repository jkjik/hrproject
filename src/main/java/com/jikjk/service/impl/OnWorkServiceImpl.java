package com.jikjk.service.impl;

import com.jikjk.dao.OnWorkDao;
import com.jikjk.entity.OnWork;
import com.jikjk.service.OnWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
@Service
public class OnWorkServiceImpl implements OnWorkService{
    @Autowired
    private OnWorkDao onWorkDao;

    public void insert(OnWork onWork) {
        onWorkDao.insert(onWork);
    }

    public void update(OnWork onWork) {
        onWorkDao.update(onWork);
    }

    public List<OnWork> selectAll() {
        return onWorkDao.selectAll();
    }

    public List<OnWork> selectByEid(int eId) {
        return onWorkDao.selectByEid(eId);
    }

    public OnWork selectByLike(String startTimeLike, int eId) {
        return onWorkDao.selectByLike(startTimeLike,eId);
    }

    public List<OnWork> selectMonthWorkTime(String monthWorkTime, int eId) {
        return onWorkDao.selectMonthWorkTime(monthWorkTime,eId);
    }


}
