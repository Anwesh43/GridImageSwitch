package com.anwesome.ui.gridswitch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class GridSwitchView extends View {
    private int time = 0,maxH = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<GridElement> gridElements = new ArrayList<>();
    private AnimationController animationController;
    public void addGridElement(Bitmap bitmap) {
        GridElement gridElement = new GridElement(bitmap);
        this.gridElements.add(gridElement);
    }
    public GridSwitchView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight(),gap = w/7;
        if(time == 0) {
            animationController = new AnimationController(this,gridElements);
            int x = 3*gap/2,y = 3*gap/2,i=0;
            for(GridElement gridElement:gridElements) {
                gridElement.setDimension(x,y,gap);
                x+=2*gap;
                i++;
                if(i == 3) {
                    x = 3*gap/2;
                    y += 2*gap;
                    i = 0;
                    maxH+=2*gap;
                }
            }
            maxH += 3*gap/2;
        }
        for(GridElement gridElement:gridElements) {
            gridElement.draw(canvas,paint,gap);
        }
        time++;
        animationController.animate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            animationController.handleTap(x,y);
        }
        return true;
    }
}
