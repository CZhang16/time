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
import android.widget.ListView;
import android.widget.TextView;

import com.time.time.BaseActivity;
import com.time.time.R;
import com.time.time.bean.Event;
import com.time.time.util.DBUtil;

import java.util.List;

public class DailyEventEditActivity extends BaseActivity {

    private RecyclerView mEventList;

    private ListView mDailyEvent;

    private List<Event> mEventDataList;

    private List<Event> mDailyEventDataList;

    private ArrayAdapter<Event> mDailyEventAdapter;

    private EventAdapter mEventAdapter;

    private Button mSaveButton;

    @Override
    protected void onResume() {
        super.onResume();
        mEventDataList = DBUtil.getEventList();
        mEventAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_event_edit);
        mEventList = (RecyclerView) findViewById(R.id.event_list);
        mDailyEvent = (ListView) findViewById(R.id.daily_event_list);
        mSaveButton = (Button) findViewById(R.id.save_daily_event);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyEventEditActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        //mDailyEventAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, mDailyEventDataList);

        //mDailyEvent.setAdapter(mDailyEventAdapter);


        mEventDataList = DBUtil.getEventList();
        mEventAdapter = new EventAdapter(mEventDataList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mEventList.setLayoutManager(manager);
        mEventList.setAdapter(mEventAdapter);

    }


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
            ViewHolder holder = new ViewHolder(view);

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //添加日程
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
