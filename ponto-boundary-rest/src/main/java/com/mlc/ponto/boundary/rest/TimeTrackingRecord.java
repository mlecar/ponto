package com.mlc.ponto.boundary.rest;

import java.util.Calendar;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TimeTrackingRecord {

    @Id
    private String id;

    @Indexed(unique = true)
    private Date dateTime;

    public TimeTrackingRecord() {
    }

    public TimeTrackingRecord(Date day, Date time) {
        Calendar calDay = Calendar.getInstance();
        calDay.setTime(day);

        Calendar calTime = Calendar.getInstance();
        calTime.setTime(time);

        Calendar cal = Calendar.getInstance();
        cal.set(calDay.get(Calendar.YEAR), calDay.get(Calendar.MONTH), calDay.get(Calendar.DAY_OF_MONTH), calTime.get(Calendar.HOUR_OF_DAY), calTime.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, 0);
        this.dateTime = cal.getTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "TimeTrackingRecord [id=" + id + ", dateTime=" + dateTime + "]";
    }

}
