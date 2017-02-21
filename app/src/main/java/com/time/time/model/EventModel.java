package com.time.time.model;

import com.time.time.bean.Event;

import org.litepal.crud.DataSupport;

/**
 * Created by ZC on 2017/2/19.
 */

public class EventModel implements IEventModel {
    @Override
    public void saveEvent(Event event) {
        event.save();
    }

    @Override
    public void deleteEvent(String eventName) {
        loadEvent(eventName).delete();
    }

    @Override
    public Event loadEvent(String eventName) {
        Event event = DataSupport.where("eventName = ?", eventName).find(Event.class).get(0);
        return event;
    }
}
