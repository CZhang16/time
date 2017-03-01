package com.time.time.view;

import com.time.time.bean.DailyEvent;
import com.time.time.bean.Event;

import java.util.List;

/**
 * Created by ZC on 2017/2/20.
 */

public interface IDailyEventView {

    void setDate(String date);

    void setDailyEvent(DailyEvent dailyEvent);

    void setDailyEventList(List<Event> eventList);
}
