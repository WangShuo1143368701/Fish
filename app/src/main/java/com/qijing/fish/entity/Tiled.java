package com.qijing.fish.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.qijing.fish.base.BaseEntity;



/**
 * Created by User on 2017/8/8.
 */

public class Tiled extends BaseEntity {
    private final String TAG = Tiled.class.getSimpleName();
    protected Bitmap bitmap;
    public Tiled(float x, float y, float width, float height,Bitmap bitmap) {
        super(x, y, width, height);
        this.bitmap = bitmap;
    }

    @Override
    public void draw(Canvas canvas) {
        if(bitmap==null)return;

        canvas.save();
        RectF src = new RectF(x,y,width,height);
        canvas.clipRect(src);
        canvas.drawBitmap(bitmap, null, src, null);
        canvas.restore();
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
