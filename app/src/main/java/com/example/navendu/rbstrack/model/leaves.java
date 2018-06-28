package com.example.navendu.rbstrack.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by navendu on 23/6/18.
 */

public class leaves {
    String racf;
    ArrayList<String>dates;
    ArrayList<String>reasons;


    public leaves()
    {}
    public leaves(String racf)
    {
        this.racf=racf;
        dates=new ArrayList<String>();
        reasons=new ArrayList<String>();
    }

}
