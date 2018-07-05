package com.example.navendu.rbstrack.model;

/**
 * Created by navendu on 28/6/18.
 */

public class Auth {

    String value;

    public Auth(){}
    public Auth(String str)
    {
        value=str;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
