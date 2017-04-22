package com.anwesome.ui.gridswitch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class GridElement {
    private Bitmap bitmap;
    private float scale = 0,x=0,y=0,dir = 0;
    public GridElement(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public void setDimension(float x,float y,int w) {
        this.x = x;
        this.y = y;
        bitmap = Bitmap.createScaledBitmap(bitmap,w/2,w/2,true);
    }
    public void draw(Canvas canvas, Paint paint,float size) {
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
    public void update() {
        
    }
    public int hashCode() {
        return bitmap.hashCode()+(int)scale;
    }
}
