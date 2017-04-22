package com.anwesome.ui.gridswitch;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class MovementController {
    private float dir = 0,scale = 0;
    public float getScale() {
        return scale;
    }
    public void move() {
        scale+=dir*0.2f;
        if(scale <=0 || scale >= 1.0f) {
            dir = 0;
            if(scale<=0) {
                scale = 0;
            }
            if(scale>=1) {
                scale = 1;
            }

        }
    }
    public boolean stopped() {
        return dir == 0;
    }
    public void startUpdating() {
        dir = scale <= 0?1:-1;
    }
}
