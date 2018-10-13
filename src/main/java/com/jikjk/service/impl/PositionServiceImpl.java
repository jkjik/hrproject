package com.jikjk.service.impl;

import com.jikjk.dao.DepartmentDao;
import com.jikjk.dao.PositionDao;
import com.jikjk.entity.Position;
import com.jikjk.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private DepartmentDao departmentDao;
    //ͨ������id��ѯְλ
    public List<Position> selectById(int pId) {
        return positionDao.selectById(pId);
    }
    //��ѯ����ְλ
    public List<Position> selectAll() {
        return positionDao.selectAll();
    }
    //ͨ��ְλ���Ʋ�ѯ��������
    public String selectNameByPid(String pName){
        //dIdΪ��
        int dId=positionDao.selectDidByName(pName);
        return departmentDao.selectNameByDid(dId);
    }
}
