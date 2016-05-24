package com.mlc.ponto.boundary.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeForm {

    private Date day;
    private Date time;

    public DateTimeForm() {

    }

    public Date getDay() {
        return day;
    }

    public void setDay(String day) {
        DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.day = (Date) dayFormat.parse(day);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data invalida", e);
        }
    }

    public Date getTime() {
        return time;
    }

    public void setTime(String time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hhmm");
        try {
            this.time = (Date) timeFormat.parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Hora invalida", e);
        }
    }

}
