package com.time.time.model;

import com.time.time.bean.Event;

/**
 * Created by ZC on 2017/2/19.
 */

public interface IEventModel {

    void saveEvent(Event event);

    void deleteEvent(String eventName);

    Event loadEvent(String eventName);


}
