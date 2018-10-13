package com.jikjk.dao;

import com.jikjk.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface PositionDao {
    //通过部门id查询职位
    public List<Position> selectById(int dId);
    //查询所有职位
    public List<Position> selectAll();
    //通过职位名称查询部门id
    public int selectDidByName(String pName);
}
