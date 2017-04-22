package com.anwesome.ui.gridswitch;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class MovementController {
    private float dir = 0,scale = 0;
    public void move() {
        scale+=dir*0.1f;
        if(scale <=0 || scale >= 1.0f) {
            dir = 0;
        }
    }
    public boolean stopped() {
        return dir == 0;
    }
    public void startUpdating() {
        dir = scale == 0?1:-1;
    }
}
