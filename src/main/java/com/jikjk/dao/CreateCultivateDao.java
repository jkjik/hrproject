package com.jikjk.dao;

import com.jikjk.entity.CreateCultivate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/19.
 */
@Repository
public interface CreateCultivateDao {
    //添加培训
    public void insert(CreateCultivate createCultivate);
    //通过dId查看培训
    public List<CreateCultivate> selectByDuty(String cDuty);
}
