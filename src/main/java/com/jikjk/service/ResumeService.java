package com.jikjk.service;

import com.jikjk.entity.Resume;

/**
 * Created by lenovo on 2018/10/13.
 */
public interface ResumeService {
    public void insert(Resume resume);
    public Resume selectByUid(int uId);
}
