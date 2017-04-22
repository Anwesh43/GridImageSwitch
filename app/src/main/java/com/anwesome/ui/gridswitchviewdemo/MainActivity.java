package com.anwesome.ui.gridswitchviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.gridswitch.GridSwitch;
import com.anwesome.ui.gridswitch.GridSwitchView;
import com.anwesome.ui.gridswitch.OnSelectionListener;

public class MainActivity extends AppCompatActivity {
    private int resources[] = {R.drawable.bluetooth,R.drawable.data,R.drawable.sync,R.drawable.wifi};
    private Bitmap bitmaps[] = new Bitmap[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<resources.length;i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),resources[i]);
        }
        GridSwitch gridSwitch = new GridSwitch(this);
        for(int i=0;i<bitmaps.length*10;i++) {
            final int index = i+1;
            gridSwitch.addGridElement(bitmaps[i % bitmaps.length], new OnSelectionListener() {
                @Override
                public void onSelect() {
                    Toast.makeText(MainActivity.this, "Toast number "+index+" selected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onUnSelect() {
                    Toast.makeText(MainActivity.this, "Toast number "+index+" unselected", Toast.LENGTH_SHORT).show();
                }
            });
        }
        gridSwitch.show();
    }
}
