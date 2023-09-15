package com.zwh.demoapp;

import android.app.Application;
import android.content.Context;

/**
 * @author: zhaowh
 * @date: 2022/10/28
 */
public class MyApplication extends Application {

    public static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static Context getInstance() {
        return application;
    }
}
