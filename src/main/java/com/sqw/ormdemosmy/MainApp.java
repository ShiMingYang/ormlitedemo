package com.sqw.ormdemosmy;

import android.app.Application;

public class MainApp  extends Application {
    private static MainApp mainApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mainApp=this;
    }

    public static MainApp getMainApp() {

        return mainApp;
    }
}
