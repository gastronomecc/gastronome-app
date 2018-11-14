package com.kevintoh0305gmail.gastronome;

import java.util.Date;

public class Logs {

    Date date;
    String title;
    String uid;

    public Logs () {}

    public Logs(Date date, String title, String uid) {
        this.date = date;
        this.title = title;
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
