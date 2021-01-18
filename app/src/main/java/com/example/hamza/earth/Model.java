package com.example.hamza.earth;

public class Model {
    double str;
    String location,date ,url;


    public Model(double str, String location, String date) {
        this.str = str;
        this.location = location;
        this.date = date;
    }

    public Model(double str, String location, String date, String url) {
        this.str = str;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getStr() {
        return str;
    }

    public void setStr(double str) {
        this.str = str;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}





