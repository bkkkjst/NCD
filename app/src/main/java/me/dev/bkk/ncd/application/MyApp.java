package me.dev.bkk.ncd.application;

import android.app.Application;


/**
 * Created by BKK on 24/6/2558.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/ThaiSansNeue-Light.otf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
//        FontsOverride.setDefaultFont(this, "DEFAULT", "MyFontAsset.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/ThaiSansNeue-Light.otf");
//        FontsOverride.setDefaultFont(this, "SERIF", "MyFontAsset3.ttf");
//        FontsOverride.setDefaultFont(this, "SANS_SERIF", "MyFontAsset4.ttf");
    }


}
