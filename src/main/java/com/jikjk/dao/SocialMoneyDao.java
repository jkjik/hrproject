package com.jikjk.dao;

import com.jikjk.entity.SocialMoney;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@Repository
public interface SocialMoneyDao {
    //添加社保
    public void insert(SocialMoney socialMoney);
    //查询员工的社保
    public SocialMoney selectSocialMoney(int eId);
    //修改员工社保
    public void updateSocial(int eId,int sMoney);
    //查询所有员工的社保
    public List<SocialMoney> selectAll();
}
