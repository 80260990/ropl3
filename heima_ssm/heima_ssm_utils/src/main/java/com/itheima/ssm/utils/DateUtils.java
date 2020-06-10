package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Date 2020/5/17 20:11
 * @Created by Leslie
 */
public class DateUtils {
    /**
    * @Description: 把日期转换成字符串
    * @Param:   Date date, String pattern
    * @return:String
    * @Author: Mr.jiang
    * @Date: 2020/5/17
    */
    public static String date2String(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
    * @Description: 把字符串转换成日期
    * @Param:  String str,String pattern
    * @return: Date
    * @Author: Mr.jiang
    * @Date: 2020/5/17
    */
    public static Date String2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
