package com.time.time.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.time.time.BaseActivity;
import com.time.time.R;
import com.time.time.bean.DailyEvent;
import com.time.time.bean.Event;
import com.time.time.model.DailyEventModel;
import com.time.time.model.IDailyEventModel;
import com.time.time.util.DBUtil;
import com.time.time.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class DailyEventEditActivity extends BaseActivity implements View.OnClickListener {

    IDailyEventModel mDailyEventModel = new DailyEventModel();

    //列表显示所有事件
    private RecyclerView mEventList;

    //列表显示日程
    private ListView mDailyEvent;

    //设置事件开始时间
    private EditText mTimeStart;

    //设置事件持续时长
    private EditText mTimeSpend;

    //所有事件信息
    private List<Event> mEventDataList;

    //每天日程事件信息
    private List<Event> mDailyEventDataList;

    //日程信息列表适配器
    private ArrayAdapter<Event> mDailyEventAdapter;

    //所有时间列表适配器
    private EventAdapter mEventAdapter;

    //添加事件按钮
    private Button mAddEvent;

    //添加事件进入日程按钮
    private Button mSaveButton;

    @Override
    protected void onResume() {
        super.onResume();
        //刷新事件列表
        List<Event> tempList = DBUtil.getEventList();
        mEventDataList.clear();
        for (Event e : tempList) {
            mEventDataList.add(e);
        }
        mEventAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_event_edit);
        //初始化控件
        mEventList = (RecyclerView) findViewById(R.id.event_list);
        mDailyEvent = (ListView) findViewById(R.id.daily_event);
        mSaveButton = (Button) findViewById(R.id.save_daily_event);
        mAddEvent = (Button) findViewById(R.id.add_event);
        mTimeSpend = (EditText) findViewById(R.id.time_spend);
        mTimeStart = (EditText) findViewById(R.id.time_start);

        mDailyEventDataList = new ArrayList<>();

        //添加监听器
        mAddEvent.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);

        mDailyEventAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, mDailyEventDataList);

        mDailyEvent.setAdapter(mDailyEventAdapter);

        //显示所有事件列表设置
        mEventDataList = DBUtil.getEventList();
        mEventAdapter = new EventAdapter(mEventDataList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mEventList.setLayoutManager(manager);
        mEventList.setAdapter(mEventAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_event:
                Intent intent = new Intent(DailyEventEditActivity.this, EventActivity.class);
                startActivity(intent);
                break;
            case R.id.save_daily_event:
                saveDailyEvent();
                finish();
                break;
            default:
        }
    }

    private void saveDailyEvent() {
        String dayString = DateUtil.getNowTime("day");
        DailyEvent dailyEvent = new DailyEvent();
        dailyEvent.setDate(dayString);
        String jsonString = getJSONStringFormList(mDailyEventDataList);
        dailyEvent.setEventList(jsonString);
        mDailyEventModel.saveDailyEvent(dailyEvent);
    }

    private String getJSONStringFormList(List<Event> dailyEventDataList) {
        String jsonStr = null;
        if (dailyEventDataList == null) {
            return "{}";
        }
        jsonStr = new Gson().toJson(dailyEventDataList);
        return jsonStr;

    }


    //显示所有事件适配器
    private class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

        private Context mContext;

        private List<Event> mEvents;

        public EventAdapter(List<Event> eventList) {
            mEvents = eventList;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mEventNameText;

            public CardView mCardView;

            public ViewHolder(View view) {
                super(view);
                mEventNameText = (TextView) view.findViewById(R.id.event_name_text);
                mCardView = (CardView) view.findViewById(R.id.event_list_item);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mContext == null) {
                mContext = parent.getContext();
            }

            View view = LayoutInflater.from(mContext).inflate(R.layout.event_list_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //添加日程
                    String timeStart = mTimeStart.getText().toString();
                    String timeSpend = mTimeSpend.getText().toString();
                    int position = holder.getAdapterPosition();
                    Event event = mEvents.get(position);
                    event.setMinuteSpend(Integer.parseInt(timeSpend));
                    event.setStartTime(timeStart);
                    mDailyEventDataList.add(event);
                    mDailyEventAdapter.notifyDataSetChanged();

                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Event event = mEvents.get(position);
            holder.mEventNameText.setText(event.getEventName());
        }


        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }
}
