package com.qijing.fish.base;

import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

import com.qijing.fish.Interface.IDrawable;
import com.qijing.fish.Interface.ITouch;


/**
 * Created by User on 2017/8/8.
 */

public abstract class BaseEntity implements IDrawable,ITouch {
    private final String TAG=BaseEntity.class.getSimpleName();
    //播放一帧动画的时间
    protected static final long ANIM_TIMER = 100;
    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public BaseEntity(float x,float y,float width,float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void touchDown(MotionEvent ev) {

    }
    @Override
    public void touchMove(MotionEvent ev) {

    }
    @Override
    public void touchUp(MotionEvent ev) {

    }

    /********************
     * 功能：
     * 	  判断这个实体是否包含了这个点，如果包含了这个点，就返回TRUE，否则返回FALSE
     * @param x x坐标
     * @param y y坐标
     * @return 返回TRUE，否则返回FALSE
     *****************/
    public boolean isContain(float x,float y){
        RectF src = new RectF(this.x,this.y,width,height);
        return src.contains(x, y);
    }

    /********************
     * 功能：
     * 	  判断这个实体是否与这个BaseEntity相交，
     * 如果与这个BaseEntity的区域相交了，就返回TRUE，否则返回FALSE
     * @return 返回TRUE，否则返回FALSE
     *****************/
    public boolean isIntersects(BaseEntity e){
        RectF src = new RectF(x,y,width,height);
        return src.intersects(e.getX(),e.getY(),e.getWidth(),e.getHeight());
    }


    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }

    public void logger(String msg){
        Log.i("TAG", msg);
    }
}
