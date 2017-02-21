package com.time.time.presenter;

import com.time.time.bean.Event;
import com.time.time.model.EventModel;
import com.time.time.model.IEventModel;
import com.time.time.view.IEventView;

/**
 * Created by ZC on 2017/2/19.
 */

public class EventPresenter implements IEventPresenter {

    private IEventModel mEventModel;

    private IEventView mEventView;

    public EventPresenter(IEventView view){
        mEventView = view;
        mEventModel = new EventModel();
    }

    @Override
    public void saveEvent() {
        Event event = new Event();
        event.setEventName(mEventView.getEventName());
        event.setInfo(mEventView.getInfo());
        event.setMinuteSpend(mEventView.getTimeSpend());
        mEventModel.saveEvent(event);
    }

    @Override
    public void loadEvent(String eventName) {
        Event event = mEventModel.loadEvent(eventName);
        mEventView.setEventName(event.getEventName());
        mEventView.setInfo(event.getInfo());
        mEventView.setTimeSpend(event.getMinuteSpend());
    }
}
