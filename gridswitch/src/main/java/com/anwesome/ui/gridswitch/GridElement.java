package com.anwesome.ui.gridswitch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class GridElement {
    private Bitmap bitmap;
    private MovementController movementController = new MovementController();
    private float scale = 0,x=0,y=0,dir = 0;
    public GridElement(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public void setDimension(float x,float y,int w) {
        this.x = x;
        this.y = y;
        bitmap = Bitmap.createScaledBitmap(bitmap,w/2,w/2,true);
        bitmap = BitmapColorUtils.changeBitmapColor(bitmap, Constants.FORE_COLOR);
    }
    public void draw(Canvas canvas, Paint paint,float size) {
        DrawingUtil.draw(canvas,paint,bitmap,x,y,size,scale);
    }
    public void update() {
        movementController.move();
    }
    public boolean stopped() {
        boolean condition = movementController.stopped();
        return condition;
    }
    public boolean handleTap(float x,float y) {
        int w = bitmap.getWidth(),h = bitmap.getHeight();
        boolean condition = x>=this.x-w && x<=this.x+w && y>=this.y-h && y<=this.y+h;
        if(condition) {
            bitmap = BitmapColorUtils.changeBitmapColor(bitmap,Constants.FORE_COLOR);
            movementController.startUpdating();
        }
        return condition;
    }
    public int hashCode() {
        return bitmap.hashCode()+(int)scale;
    }
}
