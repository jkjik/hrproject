package com.jikjk.util;

import java.util.Calendar;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OnWorkTime {

    public static String CheckOnWork(){
        Calendar calendar=Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);    //获取年
        int month = calendar.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int time = calendar.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int min = calendar.get(Calendar.MINUTE);          //获取当前分钟
        int xx = calendar.get(Calendar.SECOND);          //获取当前秒
        if(time<9){
            return "正常";
        }
        if(9<=time&&time<12){
            return "迟到";
        }
        if(time>=12){
            return "缺勤";
        }
        return "缺勤";
    }
}
