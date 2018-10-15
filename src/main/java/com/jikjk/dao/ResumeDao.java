package com.jikjk.dao;

import com.jikjk.entity.Resume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface ResumeDao {
    //��Ӽ���
    public void insert(Resume resume);
    //ͨ���û����鿴����
    public Resume selectByUid(int uId);
    //ͨ������rId���Ҽ���
    public Resume selectByRid(int rId);
    //�޸ļ���
    public void update(@Param("uId") int uId,@Param("resume") Resume resume);
    //�鿴���м���
    public List<Resume> selectAll();
    //ͨ��ְλ�鿴����
    public List<Resume> selectByAimDuty(String aimDuty);
}
