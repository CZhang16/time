package com.time.time.presenter;

import com.time.time.bean.DailyEvent;
import com.time.time.model.IDailyEventModel;
import com.time.time.view.IDailyEventView;

/**
 * Created by ZC on 2017/2/20.
 */

public class DialyEventPresenter implements IDailyEventPresenter {

    private IDailyEventModel mDailyEventModel;

    private IDailyEventView mDailyEventView;

    public DialyEventPresenter(IDailyEventView dailyEventView) {
        mDailyEventView = dailyEventView;
    }

    @Override
    public void saveDailyEvent() {
        
    }

    @Override
    public void loadDailyEvent(String date) {
        DailyEvent dailyEvent = mDailyEventModel.loadDailyEvent(date);
        mDailyEventView.setDailyEvent(dailyEvent);
    }
}
