package com.zh.test.util;


import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class DateUtils {

    private static final Calendar cal = Calendar.getInstance();
    /**
     * 根据相应的格式初始化日期格式对象
     *
     * @param pattern
     * @return
     */
    public static DateFormat getDateFormat(final String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取当前年月(如：201803)
     *
     * @return
     */
    public static String getCurrentYearMonth() {
        Date now = new Date();
        return getDateFormat("yyyyMM").format(now);
    }

    /**
     * 获取当前年月日(如：20180301)
     *
     * @return
     */
    public static String getCurrentYearMonthDay() {
        Date now = new Date();
        return getDateFormat("yyyyMMdd").format(now);
    }
    /**
     * 获取昨天的年月日
     *
     * @return
     */
    public static String getYesterdayYearMonthDay() {
        return getYearMonthDayBefore(1);
    }

    //yyyymmdd
    public static String getYearMonthDayBefore(int beforeDay) {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(beforeDay).toString().replace("-","");
    }

    public static String getCurrentYearMonthDayMinutes() {
        Date now = new Date();
        return getDateFormat("yyyyMMddHHmm").format(now);
    }

    public static String getCurrentYearMonthDayMinutesAndSeconds(){
        Date now = new Date();
        return getDateFormat("yyyyMMddHHmmssSSS").format(now);
    }

    /**
     * 获取指定年月的第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
//        System.out.println("-----1------firstDay:" + firstDay);
        return firstDay;
    }
    /**
     * 获取当天的下一天
     *
     * @return
     */
    public static String getNextDay() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(-1);
        return localDate.toString();
    }

    public static String formatYearMonthDay(String localTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(localTime);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = formatter.format(date);
        return sDate;
    }


    /**
     * local时间转换成UTC时间
     *
     * @param localTime
     * @return
     */
    public static String formatDate(String localTime) throws ParseException {
        return localToUTC(localTime);
    }
    /**
     * local时间转换成UTC时间
     *
     * @param str
     * @return
     */
    public static String formatStr(String str) throws ParseException {
        return formatDate(str + " 00:00:00");
    }

    /**
     * local时间转换成UTC时间
     *
     * @param end
     * @return
     */
    public static String formatEnd(String end) throws ParseException {
        return formatDate(end + " 23:59:00");
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }


    /**
     * local时间转换成UTC时间
     * @param localTime
     * @return
     */
    public static String localToUTC(String localTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date localDate= null;
        try {
            localDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long localTimeInMillis=localDate.getTime();
        /** long时间转换成Calendar */
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(localTimeInMillis);
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        /** 取得的时间就是UTC标准时间 */
        Date utcDate=new Date(calendar.getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String sDate = formatter.format(utcDate);
        return sDate;
    }

    /**
     * utc时间转成local时间
     * @param utcTime
     * @return
     */
    public static String utcToLocal(String utcTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  getLocalDate(locatlDate);
    }

    /**
     * utc时间转成local时间
     * @param utcTime
     * @return 返回值为Date类型
     */
    public static Date utcToLocalDate(String utcTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  locatlDate;
    }

    /**
     * utc时间转成local月份
     * @param utcTime
     * @return
     */
    public static String utcToLocalMonth(String utcTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  getLocalMonth(locatlDate);
    }

    /**
     * utc时间转成local日期
     * @param utcTime
     * @return 返回值为Date类型
     */
    public static String utcToLocalDateDate(String utcTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        String localTime = sdf2.format(utcDate.getTime());
        return  localTime;
    }

    /**
     * 获取本地时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取本地时间
     * @param date yyyy-MM-dd HH:mm:ss
     * @return 返回str类型 yyyy-MM-dd
     */
    public static String getDateStrByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取本地时间
     * @param str yyyy-MM-dd HH:mm:ss
     * @return 返回str类型 yyyy-MM-dd
     */
    public static String getDateStrByStr(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(str);
        return getDateStrByDate(date);
    }

    /**
     * 获取本地时间
     *
     * @return 返回时间类型 yyyy-MM
     */
    public static String getLocalMonth(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取date的时分秒
     * @param date
     * @return
     */
    public static String getHourAndMinAndSecond(Date date) {
        if(ObjectUtils.isEmpty(date)){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取小时
     * @param date
     * @return
     */
    public static int getHour(Date date){
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     * @param date
     * @return
     */
    public static int getMin(Date date){
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }
    /**
     * 将HH:mm类型的时间转换为当天yyyy-MM-dd HH:mm时间
     * @param time
     * @return 返回时间类型为Date
     * @throws ParseException
     */
    public static Date initDateByDay(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
        String format = dateFormat.format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINA);
        Date parse = sdf.parse(String.join(" ", format, time));
        return parse;
    }

    //字符串转时间
    public static Date strToDateLong(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date strtodate = formatter.parse(strDate);
        return strtodate;
    }

    public static Date str2ToDateLong(String strDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date strtodate = formatter.parse(strDate);
        return strtodate;
    }

    public static String getCurrentFormatTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    /**
     * yyyymmdd转localdate
     * @return
     */
    public static String formatDateWithSeparator(String intDate, String separator){
        if (Objects.isNull(intDate)){
            return "";
        }
        return intDate.substring(0, 4) + separator + intDate.substring(4, 6) + separator + intDate.substring(6, 8);
    }
}
