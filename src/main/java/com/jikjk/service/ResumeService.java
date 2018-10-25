package com.jikjk.service;

import com.jikjk.entity.Resume;

import java.util.List;

/**
 * Created by lenovo on 2018/10/13.
 */
public interface ResumeService {
    //��Ӽ���
    public void insert(Resume resume);
    //ͨ���û����鿴����
    public Resume selectByUid(int uId);
    //ͨ������rId���Ҽ���
    public Resume selectByRid(int rId);
    //�޸ļ���
    public void update(Resume resume);
    //�鿴���м���
    public List<Resume> selectAll();
    //ͨ��ְλ�鿴����
    public List<Resume> selectByAimDuty(String aimDuty);
}
