package com.qijing.fish.base;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

import com.qijing.fish.BitmapManager;

/**
 * Created by User on 2017/8/8.
 */

public abstract class   BaseFish {
    public static final String TAG=BaseFish.class.getSimpleName();
    //当前容器的高度 宽度
    public int widthGroup= BitmapManager.getInstance().displayWidth;
    public int heigthGroup=BitmapManager.getInstance().heigthGroup;

    protected Matrix matrix = new Matrix();

    protected Paint paint = new Paint();

    public abstract void draw(Canvas canvas);

    public abstract void onCreate();

    public abstract void onUpdate();

    public abstract void onDestroy();

    public boolean isDisappear; //是否消失

    public boolean isMove=true; //是否移动

    public int initX;//初始位置

    public int initY;//初始位置

    public int track;
    public int typefish;
    public BaseFish(int typefish,int track) {
        this.track=track;
        this.typefish=typefish;
    }

    public int getInitX() {
        return initX;
    }

    public void setInitX(int initX) {
        this.initX = initX;
    }

    public boolean isDisappear() {
        return isDisappear;
    }

    public void setDisappear(boolean disappear) {
        isDisappear = disappear;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public boolean isDie() {
        return isDie;
    }

    public void setDie(boolean die) {
        isDie = die;
    }

    private boolean isDie; //是否被捕 死亡

    public RectF target;


    public RectF getTarget() {
        return target;
    }

    public void setTarget(RectF target) {
        this.target = target;
    }

    public int getInitY() {
        return initY;
    }

    public void setInitY(int initY) {
        this.initY = initY;
    }
}
