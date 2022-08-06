package cn.lsr.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 日期工具类
 * @Author: lsr
 * @Date 2022年08月02日 14:46
 */
public class DateUtil {
    private static String dataFormat = "YYYY-MM-DD HH:mm:ss";

    /**
     * 获取当前系统前一天的时间
     *
     * @return date类型
     */
    public static Date getYesterdayDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前系统前一天的时间
     *
     * @return String类型
     */
    public static String getYesterdayTime() {
        SimpleDateFormat df = new SimpleDateFormat(dataFormat);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return df.format(date);
    }


    /**
     * 获取系统一周前的时间
     *
     * @return date 类型
     */
    public static Date getLastWeakDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取系统一周前的时间
     *
     * @return string类型
     */
    public static String getLastWeakTime() {
        SimpleDateFormat df = new SimpleDateFormat(dataFormat);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        date = calendar.getTime();
        return df.format(date);
    }

    /**
     * 获取系统一月前的时间
     *
     * @return date类型
     */
    public static Date getLastMonthDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取系统一月前的时间
     *
     * @return string类型
     */
    public static String getLastMonthTime() {
        SimpleDateFormat df = new SimpleDateFormat(dataFormat);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        date = calendar.getTime();
        return df.format(date);
    }

    /**
     * 获取当前系统时间前一年的时间
     *
     * @return date类型
     */
    public static Date getLastYearDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前系统时间前一年的时间
     *
     * @return string类型
     */
    public static String getLastYear() {
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        date = calendar.getTime();
        return format.format(date);
    }

    /**
     * 获取日期是当天的几小时
     *
     * @param date 传入时间
     * @return 返回时间是几点
     */
    public static int getDateIsWhatHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前日期，当月天数
     *
     * @return 当月天数
     */
    public static int getCurrentDateMonthHaveDays() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int day = cal.getActualMaximum((Calendar.DATE));
        return day;
    }

    /**
     * 获取当前日期为星期几
     *
     * @param date
     * @return 0-6 星期天，星期一，星期二 ... 星期六
     */
    public static int getDateOfTheWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            return 0;
        }
        return week;
    }

    /**
     * 获取当前日期在当月的几号
     *
     * @return
     */
    public static int getDayOfTheMonthInDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 获取当月多少天
     *
     * @return
     */
    public static int getCurrentMonthDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        int maxDay = cal.get(Calendar.DATE);
        return maxDay;
    }

    /**
     * 获取指定时间所属当月多少天
     *
     * @return
     */
    public static int getDateMonthDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        int maxDay = cal.get(Calendar.DATE);
        return maxDay;
    }

    /**
     * 获取当前日期在这个月几号
     * @param date
     * @return
     */
    public static int getDateInMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

}
