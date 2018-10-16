package com.jikjk.dao;

import com.jikjk.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface EmployeeDao {
    //����Ա��
    public void insert(Employee employee);
    //�鿴����Ա��
    public List<Employee> selectAll();
    //ͨ��eId�鿴Ա��
    public Employee SelectByEid(int eId);
    //�޸�
    public void updateAll(@Param("eId") int eId, @Param("employee") Employee employee);
    //�޸�ְλ
    public void updateDuty(@Param("eId") int eId,@Param("dId") int dId,@Param("duty") String duty);
    //�޸�״̬
    public void updateState(@Param("eId") int eId,@Param("eState") int eState);
    //��ѯ�����ŵ�����Ա��
    public List<Employee> selectEmployee(int dId);
}