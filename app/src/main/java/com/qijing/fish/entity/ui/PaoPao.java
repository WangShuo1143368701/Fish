package com.qijing.fish.entity.ui;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.qijing.fish.base.BaseFish;
import com.qijing.fish.BitmapManager;

import java.util.Random;

/**
 * Created by User on 2017/8/10.
 */

public class PaoPao extends BaseFish{

    public RectF box;
    public RectF targetBox;
    private Random random = new Random();

    public PaoPao(int type,int track) {
        super(type,track);
        box = new RectF();
        targetBox = new RectF();
        matrix.reset();
        matrix.postTranslate(widthGroup*random.nextFloat()-30, heigthGroup-38);
        box.set(0, 0, BitmapManager.getInstance().PaoPao.getWidth(), BitmapManager.getInstance().PaoPao.getHeight());
    }


    @Override
    public void draw(Canvas canvas) {
        matrix.mapRect(targetBox, box);
        //绘制
        canvas.save();
        canvas.drawBitmap(BitmapManager.getInstance().PaoPao, matrix, paint);
        canvas.restore();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onUpdate() {
        if(isMove){
            matrix.postTranslate(0, -4);
            if (targetBox.top != 0 && targetBox.top < 13) {
               setDisappear(true);
            }
        }

    }

    @Override
    public void onDestroy() {

    }
}
