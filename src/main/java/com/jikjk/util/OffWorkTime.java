package com.jikjk.util;

import java.util.Calendar;

/**
 * Created by lenovo on 2018/10/16.
 */
public class OffWorkTime {

    public static String CheckOnWork(){
        Calendar calendar=Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);    //获取年
        int month = calendar.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int time = calendar.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int min = calendar.get(Calendar.MINUTE);          //获取当前分钟
        int xx = calendar.get(Calendar.SECOND);          //获取当前秒

        if(time<18){
            return "早退";
        }
        if(18<=time&&time<21){
            return "正常";
        }
        if(time>=21){
            return "加班";
        }
        return "早退";
    }
}
