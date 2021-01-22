package com.fy.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 日期转换成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String date2String(Date date, String patt){
        //生成的字符串类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        //日期转换成字符串
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 字符串转换为日期
     * @param string
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String string,String patt) throws ParseException {
        //字符串类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        //解析字符串为Date类型
        Date parse = simpleDateFormat.parse(string);
        return parse;
    }
}
