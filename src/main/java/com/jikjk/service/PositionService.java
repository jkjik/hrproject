package com.jikjk.service;

import com.jikjk.entity.Position;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
public interface PositionService {
    //ͨ������id��ѯְλ
    public List<Position> selectById(int dId);
    //��ѯ����ְλ
    public List<Position> selectAll();
    //ͨ��ְλ���Ʋ�ѯ��������
    public String selectNameByPid(String pName);
}
