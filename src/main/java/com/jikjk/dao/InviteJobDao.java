package com.jikjk.dao;

import com.jikjk.entity.InviteJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface InviteJobDao {
    //添加招聘
    public void insert(InviteJob inviteJob);
    //修改招聘
    public void update(@Param("ijId") int ijId,@Param("inviteJob") InviteJob inviteJob);
    //删除招聘信息
    public void delete(int ijId);
    //查找所有招聘信息
    public List<InviteJob> selectAll();
}
