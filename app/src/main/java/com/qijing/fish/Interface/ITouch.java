package com.qijing.fish.Interface;

import android.view.MotionEvent;

/**
 * Created by User on 2017/8/8.
 */

public interface ITouch {
    public void touchUp(MotionEvent ev);
    public void touchDown(MotionEvent ev);
    public void touchMove(MotionEvent ev);
}
