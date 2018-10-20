package com.jikjk.service;

import com.jikjk.entity.Position;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
public interface PositionService {
    //通过部门id查询职位
    public List<Position> selectById(int dId);
    //查询所有职位
    public List<Position> selectAll();
    //通过职位名称查询部门名称
    public String selectNameByPid(String pName);
    //通过职位名称查询部门id
    public int selectDidByName(String pName);
    //添加职位
    public void insert(Position position);
    //删除职位
    public void delete(int pId);
    //修改职位
    public void updatePos(Position position);
    //通过dId删除职位
    public void deleteByDid(int dId);
}
