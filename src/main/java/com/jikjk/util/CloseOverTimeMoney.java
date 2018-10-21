package com.jikjk.util;

import com.jikjk.entity.OverTimeMoney;

import java.util.List;

/**
 * Created by lenovo on 2018/10/20.
 */
public class CloseOverTimeMoney {
    public static int getOverMoney(List<OverTimeMoney> overTimeMonies){
        int closeMoney=0;
        for(OverTimeMoney m:overTimeMonies){
            closeMoney =+m.getoMoney();
        }
        return closeMoney;
    }
}
