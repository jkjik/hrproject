package com.jikjk.service;

import com.jikjk.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
public interface EmployeeService {
    //���Ա��
    public void insert(Employee employee);
    //�鿴����Ա��
    public List<Employee> selectAll();
    //ͨ��eId�鿴Ա��
    public Employee SelectByEid(int eId);
    //�޸�
    public void updateAll(int eId, Employee employee);
    //�޸�ְλ
    public void updateDuty(int eId,int dId,String duty);
    //�޸�״̬
    public void updateState(int eId,int eState);
    //��ѯ�����ŵ�����Ա��
    public List<Employee> selectEmployee(int dId);
}
