package com.anwesome.ui.gridswitch;

import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 22/04/17.
 */
public class AnimationController {
    private View view;
    private List<GridElement> gridElements = new ArrayList<>();
    private ConcurrentLinkedQueue<GridElement> tappedElements = new ConcurrentLinkedQueue<>();
    private boolean isAnimated = false;
    public AnimationController(View view,List<GridElement> gridElements) {
        this.view = view;
        this.gridElements = gridElements;
    }
    public void animate() {
        if(isAnimated) {
            for(GridElement tappedElement:tappedElements) {
                tappedElement.update();
                if(tappedElement.stopped()) {
                    tappedElements.remove(tappedElement);
                    if(tappedElements.size() == 0) {
                        isAnimated = false;
                    }
                }
            }
            try {
                Thread.sleep(50);
                view.invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public void handleTap(float x,float y) {
        for(GridElement gridElement:gridElements) {
            if(gridElement.handleTap(x,y)) {
                boolean isFirstTappedElement = tappedElements.size() == 0;
                tappedElements.add(gridElement);
                if(isFirstTappedElement) {
                    isAnimated = true;
                    view.postInvalidate();
                }
                break;
            }
        }
    }
}
