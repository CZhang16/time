package com.time.time.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by ZC on 2017/2/20.
 */

public class DailyEvent extends DataSupport {

    private int id;

    private String date;

    private List<Event> eventList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
