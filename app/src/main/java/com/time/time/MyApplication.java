package com.time.time;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by ZC on 2017/2/19.
 */

public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
