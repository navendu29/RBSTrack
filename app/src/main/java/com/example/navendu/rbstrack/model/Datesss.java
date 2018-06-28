package com.example.navendu.rbstrack.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by navendu on 23/6/18.
 */

public class Datesss {
    String date;
    String racf;
    String reason;
    String WL;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWL() {
        return WL;
    }

    public void setWL(String WL) {
        this.WL = WL;
    }

    public Datesss()
    {}

    public Datesss(String d) {
        this.date = d;

    }
}
