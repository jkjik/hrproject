package com.jikjk.service;

import com.jikjk.entity.MassageResume;
import com.jikjk.entity.respojo.ResMassageResume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
public interface MassageResumeService {
    //����������Ϣ
    public void insert(MassageResume massageResume);
    //�鿴���м���״̬
    public List<ResMassageResume> selectAll();
    //�鿴����״̬���Ƿ񱻹ۿ�,���ԣ�
    public MassageResume selectByRid(int rId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateStateRead(int rId,String stateRead);
    //ͨ������rId�޸�����״̬
    public void updateStateInterview(int rId,String stateInterview);
    //ɾ��
    public void delete(int rId);
}
