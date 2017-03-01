package com.time.time.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.time.time.BaseActivity;
import com.time.time.R;
import com.time.time.bean.DailyEvent;
import com.time.time.bean.Event;
import com.time.time.presenter.DailyEventPresenter;
import com.time.time.presenter.IDailyEventPresenter;
import com.time.time.util.DateUtil;

import java.util.List;

public class DailyEventActivity extends BaseActivity implements IDailyEventView {

    private IDailyEventPresenter mDailyEventPresenter;

    private TextView mDateText;

    private ListView mDailyEventList;

    private DailyEvent mDailyEvent;

    private ArrayAdapter<Event> mAdapter;

    private Button mAddDailyEvent;

    @Override
    protected void onResume() {
        super.onResume();
        if (!mDailyEventPresenter.loadDailyEvent(DateUtil.getNowTime("day"))) {
            Toast.makeText(this, "今天没有记录，创建记录...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DailyEventActivity.this, DailyEventEditActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_event);

        mDailyEventPresenter = new DailyEventPresenter(this);



        mDateText = (TextView) findViewById(R.id.date_text);
        mDailyEventList = (ListView) findViewById(R.id.daily_event_list);
        mAddDailyEvent = (Button) findViewById(R.id.add_daily_event);

        mAddDailyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyEventActivity.this, DailyEventEditActivity.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public void setDate(String date) {
        mDateText.setText(date);
    }

    @Override
    public void setDailyEvent(DailyEvent dailyEvent) {
        mDailyEvent = dailyEvent;
    }

    @Override
    public void setDailyEventList(List<Event> eventList) {
        mAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, eventList);
        mDailyEventList.setAdapter(mAdapter);
    }
}
