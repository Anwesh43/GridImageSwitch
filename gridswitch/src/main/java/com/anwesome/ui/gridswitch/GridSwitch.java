package com.anwesome.ui.gridswitch;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class GridSwitch {
    private Activity activity;
    private GridSwitchView gridSwitchView;
    private boolean isShown = false;
    public GridSwitch(Activity activity) {
        this.activity = activity;
        this.gridSwitchView = new GridSwitchView(activity);
    }
    public void addGridElement(Bitmap bitmap,OnSelectionListener onSelectionListener) {
        if(!isShown) {
            gridSwitchView.addGridElement(bitmap,onSelectionListener);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            if(activity instanceof AppCompatActivity) {
                ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
                if(actionBar!=null) {
                    actionBar.hide();
                }
            }
            else {
                android.app.ActionBar actionBar = activity.getActionBar();
                if(actionBar!=null) {
                    actionBar.hide();
                }
            }
            activity.setContentView(gridSwitchView);
            isShown = true;
        }
    }
}
