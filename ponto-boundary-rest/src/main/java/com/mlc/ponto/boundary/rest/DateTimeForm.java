package com.mlc.ponto.boundary.rest;

public class DateTimeForm {

    private int day;
    private int year;
    private int month;
    private int hour;
    private int minute;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "DateTimeForm [day=" + day + ", year=" + year + ", month=" + month + ", hour=" + hour + ", minute=" + minute + "]";
    }

}
