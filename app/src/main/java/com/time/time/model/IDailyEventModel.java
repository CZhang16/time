package com.time.time.model;

import com.time.time.bean.DailyEvent;

/**
 * Created by ZC on 2017/2/20.
 */

public interface IDailyEventModel {

    void saveDailyEvent(DailyEvent dailyEvent);

    DailyEvent loadDailyEvent(String date);
}
