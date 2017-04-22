package com.anwesome.ui.gridswitch;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class BitmapColorUtils {
    public static Bitmap changeBitmapColor(Bitmap bitmap,int color) {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap);
        for(int i=0;i<bitmap.getWidth();i++) {
            for(int j=0;j<bitmap.getHeight();j++) {
                int pixel = bitmap.getPixel(i,j);
                int a = Color.alpha(pixel),r = Color.red(color),g = Color.green(color),b = Color.blue(color);
                newBitmap.setPixel(i,j,Color.argb(a,r,g,b));
            }
        }
        return newBitmap;
    }
}
