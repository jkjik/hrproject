package com.jikjk.dao;

import com.jikjk.entity.Resume;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/12.
 */
@Repository
public interface ResumeDao {
    public void insert(Resume resume);
    public Resume selectByUid(int uId);
}
