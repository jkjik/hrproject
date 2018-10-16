package com.jikjk.dao;

import com.jikjk.entity.SendResume;
import com.jikjk.entity.utilpojo.ResSendResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/13.
 */
@Repository
public interface SendResumeDao {
    //�������ͼ���
    public void insert(@Param("rId") int rId, @Param("uId") int uId, @Param("sCreateTime")Date sCreateTime);
    //�鿴���ͼ���״̬���Ƿ񱻹ۿ���
    public List<SendResume> selectByUid(int uId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateReadState(@Param("rId") int rId, @Param("sStateRead") String sStateRead);
    //ͨ������rId�޸�����״̬
    public void updateInformState(@Param("rId") int rId, @Param("intvInform") String intvInform);
    //ͨ��uId�鿴����״̬�����м���
    public List<ResSendResume> selectResByUid(int uId);
}
