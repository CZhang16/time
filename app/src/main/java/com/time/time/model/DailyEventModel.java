package com.time.time.model;

import com.time.time.bean.DailyEvent;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by ZC on 2017/2/20.
 */

public class DailyEventModel implements IDailyEventModel {

    @Override
    public void saveDailyEvent(DailyEvent dailyEvent) {
        String date = dailyEvent.getDate();
        List<DailyEvent> events = DataSupport.where("date = ?", date).find(DailyEvent.class);
        if (events == null) {
            dailyEvent.save();
        } else {
            DataSupport.deleteAll(DailyEvent.class, "date = ?", date);
            dailyEvent.save();
        }

    }

    @Override
    public DailyEvent loadDailyEvent(String date) {
        List<DailyEvent> events = DataSupport.where("date = ?", date).find(DailyEvent.class);
        if (events.size() > 0) {
            DailyEvent dailyEvent = events.get(0);
            return dailyEvent;
        }
        return null;
    }
}
