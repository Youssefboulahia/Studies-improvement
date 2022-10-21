package com.example.sharkoongamer.splashscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class AlertTime extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Courses_DataBase db = new Courses_DataBase(context);
        db.update_course_time_for_today();

    }
}
