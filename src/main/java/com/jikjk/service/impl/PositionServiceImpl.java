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
    //通过部门id查询职位
    public List<Position> selectById(int pId) {
        return positionDao.selectById(pId);
    }
    //查询所有职位
    public List<Position> selectAll() {
        return positionDao.selectAll();
    }
    //通过职位名称查询部门名称
    public String selectNameByPid(String pName){
        //dId为空
        int dId=positionDao.selectDidByName(pName);
        return departmentDao.selectNameByDid(dId);
    }
}
