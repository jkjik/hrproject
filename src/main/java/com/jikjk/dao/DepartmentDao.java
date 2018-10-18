package com.jikjk.dao;

import com.jikjk.entity.Department;
import com.jikjk.entity.Employee;
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
