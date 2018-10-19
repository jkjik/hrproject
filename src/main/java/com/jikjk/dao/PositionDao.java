package com.jikjk.dao;

import com.jikjk.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface PositionDao {
    //ͨ������id��ѯְλ
    public List<Position> selectById(int dId);
    //��ѯ����ְλ
    public List<Position> selectAll();
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
