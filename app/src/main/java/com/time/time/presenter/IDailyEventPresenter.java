package com.time.time.presenter;

/**
 * Created by ZC on 2017/2/20.
 */

public interface IDailyEventPresenter {

    void saveDailyEvent();

    boolean loadDailyEvent(String date);
}
