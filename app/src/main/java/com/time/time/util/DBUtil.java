package com.time.time.util;

import com.time.time.bean.Event;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by ZC on 2017/2/19.
 */

public class DBUtil {

    public static List<Event> getEventList() {
        return DataSupport.findAll(Event.class);
    }

}
