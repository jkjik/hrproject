package com.jikjk.service;

import com.jikjk.dao.SendResumeDao;
import com.jikjk.entity.SendResume;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface SendResumeService {
    //�������ͼ���
    public void insert(int rId,int uId);
    //�鿴���ͼ���״̬���Ƿ񱻹ۿ���
    public SendResumeDao selectByUid(int uId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateReadState(int rId, String sStateRead);
    //ͨ������rId�޸�����״̬
    public void updateInformState(int rId,String intvInform);
}
