package com.jikjk.service.impl;

import com.jikjk.dao.InviteJobDao;
import com.jikjk.entity.InviteJob;
import com.jikjk.service.InviteJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Service
public class InviteJobServiceImpl implements InviteJobService{
    @Autowired
    private InviteJobDao inviteJobDao;
    public void insert(InviteJob inviteJob) {
        inviteJobDao.insert(inviteJob);
    }

    public void update(int ijId, InviteJob inviteJob) {
        inviteJobDao.update(ijId,inviteJob);
    }

    public void delete(int ijId) {
        inviteJobDao.delete(ijId);
    }

    public List<InviteJob> selectAll() {
        return inviteJobDao.selectAll();
    }
}
