package com.jikjk.dao;

import com.jikjk.entity.LeaveEmployee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/21.
 */
@Repository
public interface LeaveEmployeeDao {
    //�����ְԱ��
    public void insert(LeaveEmployee leaveEmployee);
    //��ѯ������ְԱ��
    public List<LeaveEmployee> selectAll();
}
