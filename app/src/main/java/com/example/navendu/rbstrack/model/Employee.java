package com.example.navendu.rbstrack.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by navendu on 22/6/18.
 */

public class Employee {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("racf")
        @Expose
        private String racf;
        @SerializedName("phoneno")
        @Expose
        private String phoneno;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("leaves")
        @Expose
        private Integer leaves;
        @SerializedName("leavestaken")
        @Expose
        private Integer leavestaken;
        @SerializedName("workfromhome")
        @Expose
        private Integer workfromhome;
        @SerializedName("contacts")
        @Expose
        private String contacts;
        @SerializedName("contactnames")
        @Expose
        private String contactnames;

        public Employee(String name,String racf,String phoneno,String pass,int leaves,int taken,int w,String contacts,String contact)
        {
            this.name=name;
            this.racf=racf;
            this.phoneno=phoneno;
            this.password=pass;
            this.leaves= leaves;
            this.leavestaken=taken;
            this.workfromhome=w;
            this.contacts=contacts;
            this.contactnames=contact;


        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRacf() {
            return racf;
        }

        public void setRacf(String racf) {
            this.racf = racf;
        }

        public String getPhoneno() {
            return phoneno;
        }

        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getLeaves() {
            return leaves;
        }

        public void setLeaves(Integer leaves) {
            this.leaves = leaves;
        }

        public Integer getLeavestaken() {
            return leavestaken;
        }

        public void setLeavestaken(Integer leavestaken) {
            this.leavestaken = leavestaken;
        }

        public Integer getWorkfromhome() {
            return workfromhome;
        }

        public void setWorkfromhome(Integer workfromhome) {
            this.workfromhome = workfromhome;
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
