package com.jikjk.service;

import com.jikjk.entity.InviteJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface InviteJobService {
    //添加招聘信息
    public void insert (InviteJob inviteJob);
    //修改招聘信息
    public void update (int ijId, InviteJob inviteJob);
    //删除招聘信息
    public void delete(int ijId);
    //查找所有招聘信息
    public List<InviteJob> selectAll();
}
