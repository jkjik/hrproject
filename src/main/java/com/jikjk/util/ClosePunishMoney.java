package com.jikjk.util;

import com.jikjk.entity.PunishMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/20.
 */
public class ClosePunishMoney {

    public static int getPunishMoney(List<PunishMoney> punishMoneys){
        int closeMoney=0;
        for(PunishMoney p:punishMoneys){
            closeMoney +=p.getPuMoney();
        }
        return closeMoney;
    }
}
