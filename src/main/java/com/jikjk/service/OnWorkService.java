package com.jikjk.service;

import com.jikjk.entity.OnWork;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
public interface OnWorkService {
    //�ϰ�
    public void insert(OnWork onWork);
    //�°�
    public void update(OnWork onWork);
    //�鿴����
    public List<OnWork> selectAll();
    //ͨ��eId�鿴��¼
    public List<OnWork> selectByEid(int eId);
    //ģ����ѯ������ļ�¼
    public OnWork selectByLike(String startTimeLike,int eId);
    //ģ����ѯ��ѯ��ǰ�µļ�¼
    public List<OnWork> selectMonthWorkTime(String monthWorkTime,int eId);
}
