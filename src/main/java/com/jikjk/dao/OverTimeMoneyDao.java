package com.jikjk.dao;

import com.jikjk.entity.OverTimeMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface OverTimeMoneyDao {
    //��ӼӰ๤��
    public void insert(OverTimeMoney overTimeMoney);
    //�޸ļӰ๤��
    public void updateOverTime(@Param("eId") int eId,@Param("OverTime") int overTime);
    //��ѯ����
    public List<OverTimeMoney> selectAll();
    //��ѯԱ���ļӰ๤��
    public List<OverTimeMoney> selectOverMoney(@Param("monthWorkTime")String monthWorkTime,@Param("eId")int eId);
}
