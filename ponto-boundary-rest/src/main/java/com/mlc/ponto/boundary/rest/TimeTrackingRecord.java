package com.mlc.ponto.boundary.rest;

import org.springframework.data.annotation.Id;

public class TimeTrackingRecord {

    @Id
    private String id;

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public TimeTrackingRecord() {
    }

    public TimeTrackingRecord(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "TimeTrackingRecord [id=" + id + ", day=" + day + ", month=" + month + ", year=" + year + ", hour=" + hour + ", minute=" + minute + "]";
    }

}
