package com.jikjk.dao;

import com.jikjk.entity.MassageResume;
import com.jikjk.entity.utilpojo.ResMassageResume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */
@Repository
public interface MassageResumeDao {
    //����������Ϣ
    public void insert(MassageResume massageResume);
    //�鿴���м���״̬
    public List<ResMassageResume> selectAll();
    //�鿴����״̬���Ƿ񱻹ۿ�,���ԣ�
    public MassageResume selectByRid(int rId);
    //ͨ������rId�޸Ĳ鿴״̬
    public void updateStateRead(@Param("rId") int rId, @Param("stateRead") String stateRead);
    //ͨ������rId�޸�����״̬
    public void updateStateInterview(@Param("rId") int rId, @Param("stateRead") String stateInterview);
    //ɾ��
    public void delete(int rId);
}
