package com.jikjk.dao;

import com.jikjk.entity.OnWork;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
@Repository
public interface OnWorkDao {
    //上班
    public void insert(OnWork onWork);
    //下班
    public void update(OnWork onWork);
    //查看所有
    public List<OnWork> selectAll();
    //通过eId查看记录
    public List<OnWork> selectByEid(int eId);
    //模糊查询出当天的记录
    public OnWork selectByLike(@Param("startTimeLike")String startTimeLike, @Param("eId")int eId);
    //模糊查询查询当前月的记录
    public List<OnWork> selectMonthWorkTime(@Param("monthWorkTime")String monthWorkTime,@Param("eId")int eId);
}
