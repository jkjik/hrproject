package com.jikjk.util;

import java.util.Calendar;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OffWorkTime {

    public static String CheckOnWork(){
        Calendar calendar=Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);    //��ȡ��
        int month = calendar.get(Calendar.MONTH) + 1;   //��ȡ�·ݣ�0��ʾ1�·�
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int time = calendar.get(Calendar.HOUR_OF_DAY);       //��ȡ��ǰСʱ
        int min = calendar.get(Calendar.MINUTE);          //��ȡ��ǰ����
        int xx = calendar.get(Calendar.SECOND);          //��ȡ��ǰ��

        if(time<18){
            return "����";
        }
        if(18<=time&&time<21){
            return "����";
        }
        if(time>=21){
            return "�Ӱ�";
        }
        return "����";
    }
}
