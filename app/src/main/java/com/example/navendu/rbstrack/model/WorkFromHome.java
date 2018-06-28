package com.example.navendu.rbstrack.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by navendu on 23/6/18.
 */

public class WorkFromHome {

    String racf;
    ArrayList<String> dates;
    ArrayList<String> reason;

    public WorkFromHome()
    {}
    public WorkFromHome(String racf)
    {
        this.racf=racf;
        dates=new ArrayList<String>();
        reason=new ArrayList<String>();
    }

}