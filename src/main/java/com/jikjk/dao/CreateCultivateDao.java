package com.jikjk.dao;

import com.jikjk.entity.CreateCultivate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
@Repository
public interface CreateCultivateDao {
    //�����ѵ
    public void insert(CreateCultivate createCultivate);
    //ͨ��dId�鿴��ѵ
    public List<CreateCultivate> selectByDuty(String cDuty);
}
