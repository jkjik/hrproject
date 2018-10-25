package com.jikjk.dao;

import com.jikjk.entity.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface ResumeDao {
    //添加简历
    public void insert(Resume resume);
    //通过用户名查看简历
    public Resume selectByUid(int uId);
    //通过简历rId查找简历
    public Resume selectByRid(int rId);
    //修改简历
    public void update(Resume resume);
    //查看所有简历
    public List<Resume> selectAll();
    //通过职位查看简历
    public List<Resume> selectByAimDuty(String aimDuty);
}
