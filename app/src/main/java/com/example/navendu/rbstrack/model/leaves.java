package com.example.navendu.rbstrack.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by navendu on 23/6/18.
 */

public class leaves {
    String racf;
    String date;
    String reason;


    public leaves()
    {}

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public leaves(String racf)
    {
        this.racf=racf;

    }

}
