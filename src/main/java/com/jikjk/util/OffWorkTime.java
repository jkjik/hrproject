package com.jikjk.util;

import java.sql.Timestamp;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OffWorkTime {
    public static final String time="2018-10-13 18:00:00";
    public static final long centre=54000000;//00:00:00��ʱ��
    public static final long dayTime=24*60*60*1000;
    public static final long minute=3*60*1000;
    public static final long hour=3*60*60*1000;//�Ӱ�
    public static String CheckOnWork(Timestamp timestamp){
        Timestamp timestamp1=Timestamp.valueOf(time);
        long number=timestamp.getTime()-timestamp1.getTime();
        long number1=number%dayTime;
        if(centre<number1&&number1<minute){
            return "����";
        }
        if(minute<number1&&number1<hour){
            return "����";
        }
        if(hour<number1&&number1<centre){
            return "�Ӱ�";
        }
        return null;
    }
}
