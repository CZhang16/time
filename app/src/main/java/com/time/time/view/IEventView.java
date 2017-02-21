package com.time.time.view;

/**
 * Created by ZC on 2017/2/19.
 */

public interface IEventView {

    String getEventName();

    String getInfo();

    int getTimeSpend();

    void setEventName(String eventName);

    void setInfo(String info);

    void setTimeSpend(int timeSpend);

}
