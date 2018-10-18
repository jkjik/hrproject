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
    //��Ӳ���
    public void insert(Department department);
    //ɾ������
    public void delete(int dId);
    //�޸Ĳ���
    public void upadteDep(Department department);
    //��ѯ����
    public Department selectById(int dId);
    //ͨ���������Ʋ�ѯ����
    public Department selectBydName(String dName);
}
