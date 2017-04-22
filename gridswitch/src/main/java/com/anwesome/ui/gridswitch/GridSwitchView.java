package com.anwesome.ui.gridswitch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class GridSwitchView extends View {
    private int time = 0,maxH = 0,h;
    private GestureDetector gestureDetector;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Screen screen = new Screen();
    private List<GridElement> gridElements = new ArrayList<>();
    private AnimationController animationController;
    public void addGridElement(Bitmap bitmap) {
        GridElement gridElement = new GridElement(bitmap);
        this.gridElements.add(gridElement);
    }
    public GridSwitchView(Context context) {
        super(context);
        gestureDetector = new GestureDetector(context,new ScreenGestureListener());
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),gap = w/7;
        if(time == 0) {
            h = canvas.getHeight();
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
            maxH += 2*gap+3*gap/2;
        }
        canvas.drawColor(Constants.BACK_COLOR);
        canvas.save();
        canvas.translate(0,screen.y);
        for(GridElement gridElement:gridElements) {
            gridElement.draw(canvas,paint,gap);
        }
        canvas.restore();
        time++;
        animationController.animate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    private class Screen {
        private float y=0;
    }
    private class ScreenGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            float x = event.getX(),y = event.getY();
            animationController.handleTap(x,y-screen.y);
            return true;
        }
        public boolean onScroll(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            float updatedY = screen.y-vely;
            if(updatedY >= -maxH+h && updatedY <= 0) {
                screen.y = updatedY;
            }
            postInvalidate();
            return true;
        }
    }
}
