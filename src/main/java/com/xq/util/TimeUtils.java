package com.xq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

/**
 * 时间工具类
 */

public class TimeUtils {

    public static long timeNum = new Date().getTime();


    /**
     * 返回当前日期时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateTimeToString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(timeNum);
        return dateTime;
    }

    public static Long getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(timeNum);
        long l = Long.parseLong(format);
        return l;
    }



    /**
     * 返回当前时间，格式为HH:mm:ss
     * @return
     */
    public static String getTimeToString() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String dateTime = dateFormat.format(timeNum);
        return dateTime;
    }

    /**
     * 返回当前日期，格式为yyyy-MM-dd
     *
     * @return
     */
    public static String getDateToString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = dateFormat.format(timeNum);
        return dateTime;
    }


    /**
     * 计算两个时间点之间的时间长度,返回毫秒值
     */
    public static long duringDaysByTime(long start, long end) {
        LocalDate localDate1 = getLocalDate(start);
        LocalDate localDate2 = getLocalDate(end);

        long millis = Duration.between(localDate1, localDate2).toMillis();
        return millis;
    }

    /**
     * 通过时间毫秒值获取当前日期
     *
     * @param timeDate
     * @return
     */
    public static LocalDate getLocalDate(long timeDate) {
        Date dateStart = new Date(timeDate);
        int year1 = dateStart.getYear();
        int month1 = dateStart.getMonth();
        int date1 = dateStart.getDate();
        return LocalDate.of(year1, month1, date1);
    }

    public static long timeMillis(String time) {
        DateFormat dateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = dateFormat.parse(time);
        } catch (ParseException e) {
            try {
                parse = dateFormatDate.parse(time);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return parse.getTime();
    }

    /**
     * 传入参数的时间格式yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd
     * 返回两个时间之间的天数
     * @param start     时间格式yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd
     * @param end       时间格式yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd
     * @return
     */
    public static int duringDays(String start, String end) {

        long l = Math.abs(timeMillis(start) - timeMillis(end));
        long l1 = (l-1) / 1000 / 60 / 60 / 24 +1;
        return (int) l1;
    }

    // public static void main(String[] args) {
    //     System.out.println(duringDays("2019-12-12", "2019-12-11"));
    // }
}
