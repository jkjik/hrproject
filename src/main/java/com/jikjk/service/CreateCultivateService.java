package com.jikjk.service;

import com.jikjk.entity.CreateCultivate;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
public interface CreateCultivateService {
    //�����ѵ
    public void insert(CreateCultivate createCultivate);
    //ͨ��dId�鿴��ѵ
    public List<CreateCultivate> selectByDuty(String cDuty);
}
