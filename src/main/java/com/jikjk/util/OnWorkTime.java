package com.jikjk.util;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OnWorkTime {
    public static final String time="2018-10-13 09:00:00";
    public static final long centre=54000000;//00:00:00的时间
    public static final long dayTime=24*60*60*1000;
    public static final long minute=3*60*1000;
    public static final long hour=3*60*60*1000;
    public static String CheckOnWork(Timestamp timestamp){
        Timestamp timestamp1=Timestamp.valueOf(time);
        long number=timestamp.getTime()-timestamp1.getTime();
        long number1=number%dayTime;
        if(centre<number1&&number1<minute){
            return "正常";
        }
        if(minute<number1&&number1<hour){
            return "迟到";
        }
        if(hour<number1&&number1<centre){
            return "缺勤";
        }
        return null;
    }
}
