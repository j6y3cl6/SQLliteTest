package com.example.how.sqllitetest;

/**
 * Created by How on 2017/8/5.
 */

public class UserData {
    private String name;
    private String info;
    private String date;

    public UserData(String name,String info,String date){
        this.name=name;
        this.info=info;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
