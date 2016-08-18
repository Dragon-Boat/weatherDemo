package com.example.hzzhoulong.dragonweather.applicaiton;

import android.app.Application;
import android.content.Context;

/**
 * @author hzzhoulong
 * @date 2016/8/18.
 */
public class DragonWeatherApplication extends Application {
    public Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    private static Context sContext;
}
