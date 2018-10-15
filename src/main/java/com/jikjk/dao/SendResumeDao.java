package com.jikjk.dao;

import com.jikjk.entity.SendResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/13.
 */
@Repository
public interface SendResumeDao {
    //�������ͼ���
    public void insert(@Param("rId") int rId,@Param("uId") int uId);
    //�鿴���ͼ���״̬���Ƿ񱻹ۿ���
    public SendResumeDao selectByUid(int uId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateReadState(@Param("rId") int rId, @Param("sStateRead") String sStateRead);
    //ͨ������rId�޸�����״̬
    public void updateInformState(@Param("rId") int rId, @Param("sStateRead") String intvInform);
}
