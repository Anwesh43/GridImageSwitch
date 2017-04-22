package com.anwesome.ui.gridswitch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class DrawingUtil {
    public static void draw(Canvas canvas, Paint paint, Bitmap bitmap,float x, float y, float size, float scale) {
        canvas.save();
        canvas.translate(x,y);
        Path path = new Path();
        path.addCircle(0,0,size/2, Path.Direction.CCW);
        canvas.save();
        canvas.scale(scale,scale);
        paint.setColor(Color.parseColor("#757575"));
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,-bitmap.getWidth()/2,-bitmap.getHeight()/2,paint);
        canvas.restore();
    }
}
