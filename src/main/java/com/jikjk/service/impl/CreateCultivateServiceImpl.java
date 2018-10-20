package com.jikjk.service.impl;

import com.jikjk.dao.CreateCultivateDao;
import com.jikjk.entity.CreateCultivate;
import com.jikjk.service.CreateCultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
@Service
public class CreateCultivateServiceImpl implements CreateCultivateService {
    @Autowired
    private CreateCultivateDao createCultivateDao;

    public void insert(CreateCultivate createCultivate) {
        createCultivateDao.insert(createCultivate);
    }

    public List<CreateCultivate> selectByDuty(String cDuty) {
        return createCultivateDao.selectByDuty(cDuty);
    }


}
