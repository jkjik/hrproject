package com.jikjk.service;

import com.jikjk.entity.InviteJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface InviteJobService {
    //�����Ƹ��Ϣ
    public void insert (InviteJob inviteJob);
    //�޸���Ƹ��Ϣ
    public void update (int ijId, InviteJob inviteJob);
    //ɾ����Ƹ��Ϣ
    public void delete(int ijId);
    //����������Ƹ��Ϣ
    public List<InviteJob> selectAll();
}
