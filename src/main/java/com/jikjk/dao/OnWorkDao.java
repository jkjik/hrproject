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
    //�ϰ�
    public void insert(OnWork onWork);
    //�°�
    public void update(OnWork onWork);
    //�鿴����
    public List<OnWork> selectAll();
    //ͨ��eId�鿴��¼
    public List<OnWork> selectByEid(int eId);
    //ģ����ѯ������ļ�¼
    public OnWork selectByLike(@Param("startTimeLike")String startTimeLike, @Param("eId")int eId);
    //ģ����ѯ��ѯ��ǰ�µļ�¼
    public List<OnWork> selectMonthWorkTime(@Param("monthWorkTime")String monthWorkTime,@Param("eId")int eId);
}
