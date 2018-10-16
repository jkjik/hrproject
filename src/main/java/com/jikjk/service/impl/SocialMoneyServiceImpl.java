package com.jikjk.service.impl;

import com.jikjk.dao.SocialMoneyDao;
import com.jikjk.entity.SocialMoney;
import com.jikjk.service.SocialMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Service
public class SocialMoneyServiceImpl implements SocialMoneyService{
    @Autowired
    private SocialMoneyDao socialMoneyDao;

    public void insert(SocialMoney socialMoney) {
        socialMoneyDao.insert(socialMoney);
    }

    public SocialMoney selectSocialMoney(int eId) {
        return socialMoneyDao.selectSocialMoney(eId);
    }

    public void updateSocial(int eId, int sMoney) {
        socialMoneyDao.updateSocial(eId,sMoney);
    }

    public List<SocialMoney> selectAll() {
        return socialMoneyDao.selectAll();
    }
}
