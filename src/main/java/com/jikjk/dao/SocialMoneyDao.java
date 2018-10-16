package com.jikjk.dao;

import com.jikjk.entity.SocialMoney;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface SocialMoneyDao {
    //����籣
    public void insert(SocialMoney socialMoney);
    //��ѯԱ�����籣
    public SocialMoney selectSocialMoney(int eId);
    //�޸�Ա���籣
    public void updateSocial(int eId,int sMoney);
    //��ѯ����Ա�����籣
    public List<SocialMoney> selectAll();
}
