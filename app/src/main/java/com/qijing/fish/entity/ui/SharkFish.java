package com.qijing.fish.entity.ui;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.qijing.fish.R;
import com.qijing.fish.base.BaseFish;
import com.qijing.fish.BitmapManager;

import java.util.List;


/**
 * 鲨鱼
 * Created by User on 2017/8/9.
 */

public class SharkFish extends BaseFish {


    public RectF targetBox;
    private int curFrameIndex=0;
    private long lastTime;
    protected List<Bitmap> bitmaps =null;


    public SharkFish(int typefish, int track) {
        super(typefish, track);
        matrix.reset();
        matrix.setScale(-1, 1);
        lastTime = System.currentTimeMillis();
        bitmaps = BitmapManager.getInstance().sys;
        switch (track) {
            case 1:
                matrix.setScale(-1, 1);
                setInitY(BitmapManager.getInstance().getIntDime(R.dimen.track_shark_one));
                setInitX(-bitmaps.get(0).getWidth());
//                setInitX(-BitmapManager.getInstance().sys.get(0).getWidth());
                break;
            case 2:
                setInitY(BitmapManager.getInstance().getIntDime(R.dimen.track_shark_two));

                setInitX(widthGroup);
                break;
            case 3:
                matrix.setScale(-1, 1);
                setInitY(BitmapManager.getInstance().getIntDime(R.dimen.track_shark_three));
                setInitX(-bitmaps.get(0).getWidth());
//                setInitX(-BitmapManager.getInstance().sys.get(0).getWidth());
                break;
        }


    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onUpdate() {

        if (isMove) {
            if(track==2){
                initX -= BitmapManager.getInstance().getIntDime(R.dimen.fish_swimming2);
                if (initX < -bitmaps.get(0).getWidth()) {
                    setDisappear(true);
                }
            }else {
                initX += BitmapManager.getInstance().getIntDime(R.dimen.fish_swimming);
                if (initX > widthGroup) {
                    setDisappear(true);
                }
            }

        }
    }


    @Override
    public void onDestroy() {

    }

    private  Bitmap curBitmap;
    private long end;
    @Override
    public void draw(Canvas canvas) {


        //取得帧动画图片
        long curTime = System.currentTimeMillis();
        if (curTime - end > 100) {
            end = curTime;
            if (curFrameIndex < bitmaps.size() - 1) {
                curFrameIndex++;
            } else {
                curFrameIndex = 0;
            }

        }
        if (track != 2) {
            curBitmap = Bitmap.createBitmap(bitmaps.get(curFrameIndex), 0, 0, bitmaps.get(0).getWidth(), bitmaps.get(0).getHeight(), matrix, true);
        } else {
            curBitmap = bitmaps.get(curFrameIndex);
        }

        //绘制
        canvas.save();
        targetBox = new RectF(initX, initY, initX + bitmaps.get(0).getWidth(), initY + bitmaps.get(0).getHeight());
        setTarget(targetBox);
        canvas.clipRect(targetBox);
        canvas.drawBitmap(curBitmap, null, targetBox, paint);
        canvas.restore();
        targetBox = null;
        curBitmap = null;

//

    }


}
