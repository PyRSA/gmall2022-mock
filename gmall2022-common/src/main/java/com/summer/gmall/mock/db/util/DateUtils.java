package com.summer.gmall.mock.db.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 生成几年数据的工具类(日期维度)
 */
public class DateUtils {
    static List<String> weekendIsWorkDateList = new ArrayList<String>();
    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String YYYYMMDD_ZH = "yyyy年MM月dd日";

    /**
     * 获取年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        return year;
    }

    // 获取月份
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        return month + 1;
    }

    // 获取周
    public static int getWeekOfYear(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week_of_year = c.get(Calendar.WEEK_OF_YEAR);
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            week_of_year = week_of_year - 1;
        }
        week_of_year = week_of_year;
        return week_of_year;
    }

    public static void addMini(Date date, int xx) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");

        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(date);
        nowTime.add(Calendar.MINUTE, xx);
        System.out.println(sdf.format(nowTime.getTime()));

    }

    /**
     * 获取季度
     *
     * @param date
     * @return
     */
    public static int getSeason(Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    public static Date parseDate(String strDate) {
        return parseDate(strDate, null);
    }

    /**
     * parseDate
     *
     * @param strDate
     * @param pattern
     * @return
     */
    public static Date parseDate(String strDate, String pattern) {
        Date date = null;
        try {
            if (pattern == null) {
                pattern = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            date = format.parse(strDate);
        } catch (Exception e) {

        }
        return date;
    }

    /**
     * format date
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return formatDate(date, null);
    }

    /**
     * format date
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        String strDate = null;
        try {
            if (pattern == null) {
                pattern = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            strDate = format.format(date);
        } catch (Exception e) {
            System.out.println("formatDate error:" + e);
        }
        return strDate;
    }

    /**
     * @return 是工作日返回true，非工作日返回false
     * @title 判断是否为工作日
     * @detail 工作日计算: 1、正常工作日，并且为非假期 2、周末被调整成工作日
     * <p>
     * 日期
     */
    public static boolean isWorkday(GregorianCalendar calendar) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean isWeekend = calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY && calendar.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY;
        if (isWeekend) {
            return !getWeekdayIsHolidayList().contains(dataFormat.format(calendar.getTime()));
        } else {
            return getWeekendIsWorkDateList().contains(dataFormat.format(calendar.getTime()));
        }
    }

    /**
     * @return 周末是工作日的列表
     * @title 获取周六和周日是工作日的情况（手工维护）
     */
    public static List<String> getWeekendIsWorkDateList() {
        List<String> list = new ArrayList<String>();
        //2019年数据
        list.add("2019-02-02");
        list.add("2019-02-03");
        list.add("2019-04-28");
        list.add("2019-05-05");
        list.add("2019-09-29");
        list.add("2019-10-12");

        //2020年数据
        list.add("2020-01-19");
        list.add("2020-02-01");
        list.add("2020-04-26");
        list.add("2020-05-09");
        list.add("2020-06-28");
        list.add("2020-09-27");
        list.add("2020-10-10");

        //2021年数据
        list.add("2021-02-07");
        list.add("2021-02-20");
        list.add("2021-04-25");
        list.add("2021-05-08");
        list.add("2021-09-18");
        list.add("2021-09-26");
        list.add("2021-10-09");

        //2022年数据
        list.add("2022-01-29");
        list.add("2022-01-30");
        list.add("2022-04-02");
        list.add("2022-04-24");
        list.add("2022-05-07");
        list.add("2022-10-08");
        list.add("2022-10-09");

        return list;
    }

    /**
     * @return 平时是假期的列表
     * @title 获取周一到周五是假期的情况（手工维护）
     */
    public static List<String> getWeekdayIsHolidayList() {
        if (weekendIsWorkDateList.isEmpty()) {
            //2019年数据
            weekendIsWorkDateList.add("2019-01-01");
            weekendIsWorkDateList.add("2019-02-04");
            weekendIsWorkDateList.add("2019-02-05");
            weekendIsWorkDateList.add("2019-02-06");
            weekendIsWorkDateList.add("2019-02-07");
            weekendIsWorkDateList.add("2019-02-08");
            weekendIsWorkDateList.add("2019-04-05");
            weekendIsWorkDateList.add("2019-05-01");
            weekendIsWorkDateList.add("2019-05-02");
            weekendIsWorkDateList.add("2019-05-03");
            weekendIsWorkDateList.add("2019-06-07");
            weekendIsWorkDateList.add("2019-09-13");
            weekendIsWorkDateList.add("2019-10-01");
            weekendIsWorkDateList.add("2019-10-02");
            weekendIsWorkDateList.add("2019-10-03");
            weekendIsWorkDateList.add("2019-10-04");
            weekendIsWorkDateList.add("2019-10-07");
            //2020年数据
            weekendIsWorkDateList.add("2020-01-01");
            weekendIsWorkDateList.add("2020-01-24");
            weekendIsWorkDateList.add("2020-01-27");
            weekendIsWorkDateList.add("2020-01-28");
            weekendIsWorkDateList.add("2020-01-29");
            weekendIsWorkDateList.add("2020-01-30");
            weekendIsWorkDateList.add("2020-04-06");
            weekendIsWorkDateList.add("2020-05-01");
            weekendIsWorkDateList.add("2020-05-04");
            weekendIsWorkDateList.add("2020-05-05");
            weekendIsWorkDateList.add("2020-06-25");
            weekendIsWorkDateList.add("2020-06-06");
            weekendIsWorkDateList.add("2020-10-01");
            weekendIsWorkDateList.add("2020-10-02");
            weekendIsWorkDateList.add("2020-10-05");
            weekendIsWorkDateList.add("2020-10-06");
            weekendIsWorkDateList.add("2020-10-07");
            weekendIsWorkDateList.add("2020-10-08");
            //2021年数据
            weekendIsWorkDateList.add("2021-01-01");
            weekendIsWorkDateList.add("2021-02-11");
            weekendIsWorkDateList.add("2021-02-12");
            weekendIsWorkDateList.add("2021-02-15");
            weekendIsWorkDateList.add("2021-02-16");
            weekendIsWorkDateList.add("2021-02-17");
            weekendIsWorkDateList.add("2021-04-05");
            weekendIsWorkDateList.add("2021-05-03");
            weekendIsWorkDateList.add("2021-05-04");
            weekendIsWorkDateList.add("2021-05-05");
            weekendIsWorkDateList.add("2021-06-14");
            weekendIsWorkDateList.add("2021-09-20");
            weekendIsWorkDateList.add("2021-09-21");
            weekendIsWorkDateList.add("2021-10-01");
            weekendIsWorkDateList.add("2021-10-04");
            weekendIsWorkDateList.add("2021-10-05");
            weekendIsWorkDateList.add("2021-10-06");
            weekendIsWorkDateList.add("2021-10-07");
            //2022年数据
            weekendIsWorkDateList.add("2022-01-03");
            weekendIsWorkDateList.add("2022-01-31");
            weekendIsWorkDateList.add("2022-04-04");
            weekendIsWorkDateList.add("2022-04-05");
            weekendIsWorkDateList.add("2022-05-02");
            weekendIsWorkDateList.add("2022-05-03");
            weekendIsWorkDateList.add("2022-05-04");
            weekendIsWorkDateList.add("2022-06-03");
            weekendIsWorkDateList.add("2022-09-12");
            weekendIsWorkDateList.add("2022-10-03");
            weekendIsWorkDateList.add("2022-10-04");
            weekendIsWorkDateList.add("2022-10-05");
            weekendIsWorkDateList.add("2022-10-06");
            weekendIsWorkDateList.add("2022-10-07");


        }
        return weekendIsWorkDateList;
    }


    //    public static void main(String[] args) throws ParseException {
//        Date date =new Date();
//        System.out.println(date.getMinutes());
//    }
    public static void main(String[] args) throws IOException {

        WeekdayUtil dateUtils = new WeekdayUtil();
        List<DimDayDto> dimDayDtos = dateUtils.compareWeekday("2020-01-01", "2020-01-31", 10);
        for (DimDayDto dimDayDto : dimDayDtos) {
            System.out.println(dimDayDto);
        }
//        fos.close();
    }

}