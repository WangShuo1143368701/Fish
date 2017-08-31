package com.qijing.fish.entity.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

import com.qijing.fish.Interface.IDrawable;
import com.qijing.fish.BitmapManager;

/**
 * 渔网
 * Created by User on 2017/8/10.
 */

public class NetFish implements IDrawable {
    protected Matrix matrix = new Matrix();
    public RectF box;
    public RectF targetBox;

    private long lastTime;
    private float xx,yy;
    public NetFish(float postionX, float positionY) {
        box = new RectF();
        targetBox = new RectF();
        matrix.reset();

        xx=postionX-BitmapManager.getInstance().fishNetBit.getWidth()/2f;
        yy=positionY-BitmapManager.getInstance().fishNetBit.getHeight()/2f;
        matrix.postTranslate(xx, yy);


        box.set(0, 0, BitmapManager.getInstance().fishNetBit.getWidth(), BitmapManager.getInstance().fishNetBit.getHeight());
        lastTime = System.currentTimeMillis();


    }
    private float scale=0.6f;
    public void Update(){

        if(scale<1.2){
            scale=scale+0.6f;
            matrix.preScale(scale, scale,BitmapManager.getInstance().fishNetBit.getWidth()/2,BitmapManager.getInstance().fishNetBit.getHeight()/2);
        }



    }

    @Override
    public void draw(Canvas canvas) {


        matrix.mapRect(targetBox, box);
        //绘制
        canvas.save();
        canvas.drawBitmap(BitmapManager.getInstance().fishNetBit,matrix, null);
        canvas.restore();
    }
}
