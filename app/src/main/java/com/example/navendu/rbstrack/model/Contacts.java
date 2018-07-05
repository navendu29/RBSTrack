package com.example.navendu.rbstrack.model;

import android.content.Context;

/**
 * Created by navendu on 5/7/18.
 */

public class Contacts {
String name;
String phone;

public Contacts(){}
public Contacts(String s1,String s2)
{
    name=s1;
    phone=s2;

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
