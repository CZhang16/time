package com.time.time.model;

import com.time.time.bean.DailyEvent;

import org.litepal.crud.DataSupport;

/**
 * Created by ZC on 2017/2/20.
 */

public class DailyEventModel implements IDailyEventModel {

    @Override
    public void saveDailyEvent(DailyEvent dailyEvent) {
        dailyEvent.save();
    }

    @Override
    public DailyEvent loadDailyEvent(String date) {
        DailyEvent dailyEvent = DataSupport.where("date = ?", date).find(DailyEvent.class).get(0);
        return dailyEvent;
    }
}
