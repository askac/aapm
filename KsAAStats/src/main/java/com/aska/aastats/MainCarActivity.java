package com.aska.aastats;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.google.android.apps.auto.sdk.CarActivity;
import com.google.android.apps.auto.sdk.CarUiController;
import com.google.android.apps.auto.sdk.MenuController;
import com.google.android.apps.auto.sdk.SearchController;
import com.google.android.apps.auto.sdk.StatusBarController;

public class MainCarActivity extends CarActivity {
    private static final String TAG = "MainCarActivity";

    @Override
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme_Car);
        super.onCreate(bundle);
        setContentView(R.layout.activity_car_main);

        CarUiController carUiController = getCarUiController();

        FragmentManager fragmentManager = getSupportFragmentManager();
        CarFragment fragment = new DashboardFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commitNow();

        MenuController menuController = getCarUiController().getMenuController();
        menuController.hideMenuButton();

        StatusBarController statusBarController = getCarUiController().getStatusBarController();
        fragment.setupStatusBar(statusBarController);
    }
}
