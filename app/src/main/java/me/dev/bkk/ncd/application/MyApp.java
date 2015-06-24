package me.dev.bkk.ncd.application;

import android.app.Application;

/**
 * Created by BKK on 24/6/2558.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/ThaiSansNeue-Light.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
    }
}
