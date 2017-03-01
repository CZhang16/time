package com.time.time.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by ZC on 2017/2/19.
 */

public class Event extends DataSupport {

    private int id;

    private String eventName;

    private String info;

    private int imgId;

    private String startTime;

    private int minuteSpend;

    private boolean canDelete;

    @Override
    public String toString() {
        return eventName + "\n开始时间：" + startTime + "  时长：" + minuteSpend;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getMinuteSpend() {
        return minuteSpend;
    }

    public void setMinuteSpend(int minuteSpend) {
        this.minuteSpend = minuteSpend;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
