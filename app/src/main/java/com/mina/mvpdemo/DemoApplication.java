package com.mina.mvpdemo;

import android.app.Application;
import timber.log.Timber;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimberTree();
    }

    private void setupTimberTree() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
