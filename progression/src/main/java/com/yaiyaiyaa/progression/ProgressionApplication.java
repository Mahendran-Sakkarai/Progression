package com.yaiyaiyaa.progression;

import android.content.Context;

/**
 * Created by mahendran on 29/1/16.
 */
public class ProgressionApplication extends android.app.Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
