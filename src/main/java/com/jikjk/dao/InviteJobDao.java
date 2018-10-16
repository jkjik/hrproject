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
    //�����Ƹ
    public void insert(InviteJob inviteJob);
    //�޸���Ƹ
    public void update(@Param("ijId") int ijId,@Param("inviteJob") InviteJob inviteJob);
    //ɾ����Ƹ��Ϣ
    public void delete(int ijId);
    //����������Ƹ��Ϣ
    public List<InviteJob> selectAll();
}
