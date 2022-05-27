package com.summer.gmall.mock.db.util;

import java.io.Serializable;

/**
 * <p>
 * 日-时间维表
 * </p>
 *
 * @author zsd
 * @since 2022-03-10
 */
public class DimDayDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日期yyyyMMdd
     */
    private String dayKey;

    /**
     * 日期yyyy-MM-dd
     */
    private String day;

    /**
     * 是否是工作日 1是0不是
     */
    private Integer isworkday;

    /**
     * 一年的第多少周
     */
    private Integer week;

    /**
     * 一年的第多少周名称
     */
    private String weekName;

    /**
     * 周几
     */
    private Integer weekofday;

    /**
     * 周名称
     */
    private String weekofdayName;

    /**
     * 月
     */
    private Integer month;

    /**
     * 月名称
     */
    private String monthName;

    /**
     * 季度
     */
    private Integer season;

    /**
     * 季度名称
     */
    private String seasonName;

    /**
     * 年
     */
    private Integer year;

    /**
     * 年名称
     */
    private String yearName;

    private String monthYyyyMm;

    private String weekYyyyWw;

    private Integer id;


    public String getDayKey() {
        return dayKey;
    }

    public void setDayKey(String dayKey) {
        this.dayKey = dayKey;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getIsworkday() {
        return isworkday;
    }

    public void setIsworkday(Integer isworkday) {
        this.isworkday = isworkday;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public Integer getWeekofday() {
        return weekofday;
    }

    public void setWeekofday(Integer weekofday) {
        this.weekofday = weekofday;
    }

    public String getWeekofdayName() {
        return weekofdayName;
    }

    public void setWeekofdayName(String weekofdayName) {
        this.weekofdayName = weekofdayName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public String getMonthYyyyMm() {
        return monthYyyyMm;
    }

    public void setMonthYyyyMm(String monthYyyyMm) {
        this.monthYyyyMm = monthYyyyMm;
    }

    public String getWeekYyyyWw() {
        return weekYyyyWw;
    }

    public void setWeekYyyyWw(String weekYyyyWw) {
        this.weekYyyyWw = weekYyyyWw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DimDay{" +
                "dayKey=" + dayKey +
                ", day=" + day +
                ", isworkday=" + isworkday +
                ", week=" + week +
                ", weekName=" + weekName +
                ", weekofday=" + weekofday +
                ", weekofdayName=" + weekofdayName +
                ", month=" + month +
                ", monthName=" + monthName +
                ", season=" + season +
                ", seasonName=" + seasonName +
                ", year=" + year +
                ", yearName=" + yearName +
                ", monthYyyyMm=" + monthYyyyMm +
                ", weekYyyyWw=" + weekYyyyWw +
                ", id=" + id +
                "}";
    }
}
