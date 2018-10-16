package com.jikjk.service;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import com.jikjk.entity.utilpojo.ResSendResume;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface SendResumeService {
    //�������ͼ���
    public void insert(int rId,int uId,Date sCreateTime);
    //�鿴���ͼ���״̬���Ƿ񱻹ۿ���
    public List<SendResume> selectByUid(int uId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateReadState(int rId, String sStateRead);
    //ͨ������rId�޸�����״̬
    public void updateInformState(int rId,String intvInform);
    //ͨ��uId�鿴����״̬�����м���
    public List<ResSendResume> selectResByUid(int uId);
}
