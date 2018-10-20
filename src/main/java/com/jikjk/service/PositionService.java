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
    //ͨ��ְλ���Ʋ�ѯ����id
    public int selectDidByName(String pName);
    //���ְλ
    public void insert(Position position);
    //ɾ��ְλ
    public void delete(int pId);
    //�޸�ְλ
    public void updatePos(Position position);
    //ͨ��dIdɾ��ְλ
    public void deleteByDid(int dId);
}
