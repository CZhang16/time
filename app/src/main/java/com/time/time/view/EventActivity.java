package com.time.time.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.time.time.BaseActivity;
import com.time.time.R;
import com.time.time.presenter.EventPresenter;
import com.time.time.presenter.IEventPresenter;

public class EventActivity extends BaseActivity implements IEventView, View.OnClickListener{

    private IEventPresenter mEventPresenter;

    private EditText mEventNameText;

    private EditText mEventInfoText;

    private EditText mEventSpendText;

    private Button mSaveEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mEventNameText = (EditText) findViewById(R.id.event_name_text);
        mEventInfoText = (EditText) findViewById(R.id.event_info_text);
        mEventSpendText = (EditText) findViewById(R.id.event_spend_text);
        mSaveEvent = (Button) findViewById(R.id.save_event);

        mEventPresenter = new EventPresenter(this);

        mSaveEvent.setOnClickListener(this);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra("event_name");
        if (eventName != null) {
            mEventPresenter.loadEvent(eventName);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_event:
                mEventPresenter.saveEvent();
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public String getEventName() {
        return mEventNameText.getText().toString();
    }

    @Override
    public String getInfo() {
        return mEventInfoText.getText().toString();
    }

    @Override
    public int getTimeSpend() {
        int timeSpend = Integer.parseInt(mEventSpendText.getText().toString());
        return timeSpend;
    }

    @Override
    public void setEventName(String eventName) {
        mEventNameText.setText(eventName);
    }

    @Override
    public void setInfo(String info) {
        mEventInfoText.setText(info);
    }

    @Override
    public void setTimeSpend(int timeSpend) {
        mEventSpendText.setText(timeSpend + "");
    }
}
