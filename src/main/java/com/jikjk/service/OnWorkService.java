package com.jikjk.service;

import com.jikjk.entity.OnWork;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
public interface OnWorkService {
    //上班
    public void insert(OnWork onWork);
    //下班
    public void update(OnWork onWork);
    //查看所有
    public List<OnWork> selectAll();
    //通过eId查看记录
    public List<OnWork> selectByEid(int eId);
    //模糊查询出当天的记录
    public OnWork selectByLike(String startTimeLike,int eId);
    //模糊查询查询当前月的记录
    public List<OnWork> selectMonthWorkTime(String monthWorkTime,int eId);
}
