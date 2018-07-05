package com.example.navendu.rbstrack.model;

/**
 * Created by navendu on 3/7/18.
 */

public class peopleonleave {
    String date;
    String reason;
    String what;


    public peopleonleave()
    {}

    public peopleonleave(String s1,String s2,String s3)
    {
        date=s1;
        reason=s2;
        what=s3;

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

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }




}
