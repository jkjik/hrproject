package com.jikjk.dao;

import com.jikjk.entity.InviteJob;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface InviteJobDao {
    //�����Ƹ��Ϣ
    public void insert (InviteJob inviteJob);
    //�޸���Ƹ��Ϣ
    public void update (@Param("ijId") int ijId,@Param("inviteJob") InviteJob inviteJob);
    //ɾ����Ƹ��Ϣ
    public void delete(int ijId);
    //����������Ƹ��Ϣ
    public List<InviteJob> selectAll();
}
