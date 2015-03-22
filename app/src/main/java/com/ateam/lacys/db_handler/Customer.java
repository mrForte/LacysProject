package com.ateam.lacys.db_handler;

/**
 * Created by Valentin on 2/24/2015.
 */
public class Customer
{
    //private variables
    private String customerID;
    private String fname;
    private String lname;
    private String userName;
    private String pword;

    //getters and setters for each variable
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
}