package com.jikjk.service;

import com.jikjk.entity.Department;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
public interface DepartmentService {
    //��ѯ���в���
    public List<Department> selectAll();
    //ͨ��dId��ѯ����
    public String selectNameByDid(int dId);
}
