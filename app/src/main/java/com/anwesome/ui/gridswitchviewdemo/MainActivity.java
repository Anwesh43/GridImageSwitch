package com.anwesome.ui.gridswitchviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.gridswitch.GridSwitchView;

public class MainActivity extends AppCompatActivity {
    private int resources[] = {R.drawable.bluetooth,R.drawable.data,R.drawable.sync,R.drawable.wifi};
    private Bitmap bitmaps[] = new Bitmap[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<resources.length;i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),resources[i]);
        }
        GridSwitchView gridSwitchView = new GridSwitchView(this);
        for(int i=0;i<4;i++) {
            gridSwitchView.addGridElement(bitmaps[i]);
        }
        setContentView(gridSwitchView);
    }
}
