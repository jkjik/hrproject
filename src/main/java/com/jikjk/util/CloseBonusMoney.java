package com.jikjk.util;

import com.jikjk.entity.BonusMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/20.
 */
public class CloseBonusMoney {
    public static int getBonusMoney(List<BonusMoney> bonusMonies){
    int closeMoney=0;
        for(BonusMoney b:bonusMonies){
            closeMoney +=b.getBoMoney();
        }
        return closeMoney;
    }

}
