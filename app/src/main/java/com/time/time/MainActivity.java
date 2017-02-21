package com.time.time;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.time.time.bean.Event;
import com.time.time.util.DBUtil;
import com.time.time.view.EventActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private List<Event> mEventList;

    private Button mAddEvent;

    private ListView mListView;

    private List<String> mDataList;

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddEvent = (Button) findViewById(R.id.add_event);
        mListView = (ListView) findViewById(R.id.list_view);

        mAddEvent.setOnClickListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String eventName = mDataList.get(position);
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event_name", eventName);
                startActivity(intent);
            }
        });
        mEventList = DBUtil.getEventList();

        mDataList = new ArrayList<>();
        for (Event event : mEventList) {
            mDataList.add(event.getEventName());
        }

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDataList);
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_event:
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEventList = DBUtil.getEventList();

        mDataList.clear();
        for (Event event : mEventList) {
            mDataList.add(event.getEventName());
        }
        mAdapter.notifyDataSetChanged();
    }
}
