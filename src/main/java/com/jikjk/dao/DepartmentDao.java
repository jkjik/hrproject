package com.jikjk.dao;

import com.jikjk.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface DepartmentDao {
    //��ѯ���в���
    public List<Department> selectAll();
    //ͨ��dId��ѯ����
    public String selectNameByDid(int dId);
}
