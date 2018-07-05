package com.example.navendu.rbstrack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by navendu on 1/7/18.
 */

public class cont {
    @SerializedName("racf")
    @Expose
    private String racf;
    @SerializedName("contacts")
    @Expose
    private String contacts;
    @SerializedName("contactnames")
    @Expose
    private String contactnames;


    public cont(){}
    public cont(String s1,String s2,String s3){

        racf=s1;
        contacts=s2;
        contactnames=s3;

    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactnames() {
        return contactnames;
    }

    public void setContactnames(String contactnames) {
        this.contactnames = contactnames;
    }
}
