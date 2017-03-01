package com.time.time.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by ZC on 2017/2/20.
 */

public class DailyEvent extends DataSupport {

    private int id;

    private String date;

    private String eventList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventList() {
        return eventList;
    }

    public void setEventList(String eventList) {
        this.eventList = eventList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
