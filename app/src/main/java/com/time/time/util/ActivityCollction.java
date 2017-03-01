package com.time.time.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZC on 2017/3/1.
 */

public class ActivityCollction {

    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void closeAllActivity() {
        for (Activity a : activityList) {
            a.finish();
        }
    }
}
