package com.example.navendu.rbstrack.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by navendu on 23/6/18.
 */

public class WorkFromHome {

    String racf;
    String dates;
    String reasons;

    public WorkFromHome()
    {}
    public WorkFromHome(String racf)
    {
        this.racf=racf;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }
}