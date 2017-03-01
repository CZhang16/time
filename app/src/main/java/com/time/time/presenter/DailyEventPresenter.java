package com.time.time.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.time.time.bean.DailyEvent;
import com.time.time.bean.Event;
import com.time.time.model.DailyEventModel;
import com.time.time.model.IDailyEventModel;
import com.time.time.view.IDailyEventView;

import java.util.List;

/**
 * Created by ZC on 2017/2/20.
 */

public class DailyEventPresenter implements IDailyEventPresenter {

    private IDailyEventModel mDailyEventModel;

    private IDailyEventView mDailyEventView;

    public DailyEventPresenter(IDailyEventView dailyEventView) {
        mDailyEventView = dailyEventView;
        mDailyEventModel = new DailyEventModel();
    }

    @Override
    public void saveDailyEvent() {
        
    }

    @Override
    public boolean loadDailyEvent(String date) {
        DailyEvent dailyEvent = mDailyEventModel.loadDailyEvent(date);
        if (dailyEvent != null) {
            mDailyEventView.setDailyEvent(dailyEvent);
            mDailyEventView.setDate(dailyEvent.getDate());
            List<Event> events = new Gson().fromJson(dailyEvent.getEventList(), new TypeToken<List<Event>>(){}.getType());
            mDailyEventView.setDailyEventList(events);
            return true;
        }
        return false;
    }
}
