package com.time.time.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.time.time.BaseActivity;
import com.time.time.R;
import com.time.time.bean.DailyEvent;
import com.time.time.bean.Event;
import com.time.time.presenter.DialyEventPresenter;
import com.time.time.presenter.IDailyEventPresenter;
import com.time.time.util.DateUtil;

import java.util.List;

public class DailyEventActivity extends BaseActivity implements IDailyEventView {

    private IDailyEventPresenter mDailyEventPresenter;

    private TextView mDateText;

    private ListView mDailyEventList;

    private List<Event> mDataList;

    private DailyEvent mDailyEvent;

    private ArrayAdapter<Event> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_event);

        mDailyEventPresenter = new DialyEventPresenter(this);
        mDailyEventPresenter.loadDailyEvent(DateUtil.getNowTime("day"));

        mDateText = (TextView) findViewById(R.id.date_text);
        mDailyEventList = (ListView) findViewById(R.id.daily_event_list);

        mAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, mDataList);
        mDailyEventList.setAdapter(mAdapter);
    }

    public void notifyDataList() {
        mDataList = mDailyEvent.getEventList();
    }

    @Override
    public void setDate(String date) {
        mDateText.setText(date);
    }

    @Override
    public void setDailyEvent(DailyEvent dailyEvent) {
        mDailyEvent = dailyEvent;
        setDate(mDailyEvent.getDate());
    }
}
