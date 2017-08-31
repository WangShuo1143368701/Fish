package com.qijing.fish;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.qijing.fish.Interface.IScene;
import com.qijing.fish.base.BaseFish;
import com.qijing.fish.entity.Tiled;
import com.qijing.fish.entity.ui.FishFactory;
import com.qijing.fish.entity.ui.NetFish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by User on 2017/8/8.
 */

public class GameScene implements IScene {
    private final String TAG = Tiled.class.getSimpleName();
    private Tiled background;
    public static final float BULLET_SPEED = -10;
    private List<BaseFish> fish = new ArrayList<BaseFish>();//鱼

    private List<NetFish> fishNet = new ArrayList<NetFish>();//渔网

    private List<BaseFish> paopao = new ArrayList<BaseFish>();//泡泡
    private ImageView mImgArtillery;
    private ImageView mImgBullet;
    private FishFactory fishFactory = new FishFactory();
    private FrameLayout mFramlayout;
    protected Context context;
    protected int mWidth, mHeight;

    public GameScene(Context context) {
        this.context = context;
        BitmapManager.getInstance().init(context);
        mWidth = context.getResources().getDisplayMetrics().widthPixels;
        mHeight = (int) BitmapManager.getInstance().getIntDime(R.dimen.game_height);
    }


    private int xiabiao = 0;
    private UiHandler uiHandler;
    private Random rad = new Random();

    @Override
    public void load() {
        uiHandler = new UiHandler();

        BitmapManager.getInstance().loadResources();
        //载入贴图
        background = new Tiled(0, 0, mWidth, mHeight, BitmapManager.getInstance().bg);
        fish.clear();
//        for (int i = 0; i < 6; i++) {
//            mFlyCoins.add(createCoinsView());
//        }
    }

    @Override
    public void draw(Canvas canvas) {
        background.draw(canvas);//背景
        //泡泡
        for (int i = 0; i < paopao.size(); i++) {
            paopao.get(i).draw(canvas);
            paopao.get(i).onUpdate();
        }

        //鱼
        for (int i = 0; i < fish.size(); i++) {
            fish.get(i).draw(canvas);
            fish.get(i).onUpdate();

        }

        //渔网
        for (int i = 0; i < fishNet.size(); i++) {
            fishNet.get(i).draw(canvas);
            fishNet.get(i).Update();
        }


        long endPaoPao = System.currentTimeMillis();
        if (endPaoPao - startPaoPao > 2000) {
            startPaoPao = endPaoPao;
            if (paopao.size() < 2) {
                paopao.add(fishFactory.oncreate(30, 30));
            }
        }
        fishUpdate();
    }


    private long startPaoPao;

    private long startaddfish;

    private void fishUpdate() {
        long end = System.currentTimeMillis();
        if (end - startaddfish > 2000) {
            startaddfish = end;
            fish.add(fishFactory.oncreate(Math.abs(rad.nextInt(15) + 1), 1));
            fish.add(fishFactory.oncreate(Math.abs(rad.nextInt(15) + 1), 2));
            fish.add(fishFactory.oncreate(Math.abs(rad.nextInt(15) + 1), 3));
        }


//        // 移除鱼
        for (int i = 0; i < fish.size(); i++) {
            if (fish.get(i).isDisappear()) {
                fish.remove(i);
            }
        }

        //移除泡泡
        for (int i = 0; i < paopao.size(); i++) {
            if (paopao.get(i).isDisappear) {
                paopao.remove(i);
            }
        }


    }


    /**
     * 横向鱼的位置
     *
     * @return 随机生成一个游行的轨道 位置
     *********************/
    public int getRowPositon() {
        Random random = new Random();
        return Math.abs(random.nextInt(3) + 1);

    }


    private float downX, downY;
    private long start_artilley;

    @Override
    public void touchUp(MotionEvent ev) {
        //点击了捕鱼区域，发射子弹


    }

    private float normaX, normaY, normalX, normalY;
    private float rotationX;
    private android.animation.AnimatorSet animator = null;
    private android.animation.AnimatorSet animator2 = null;

    @Override
    public void touchDown(MotionEvent ev) {
        downX = ev.getX();
        downY = ev.getY();

        Log.e(TAG, " downX " + downX + " downY " + downY);

        //点击屏幕 绘制渔网的间隔 和大炮旋转的间隔
        long end = System.currentTimeMillis();
        if (end - start_artilley > 300) {
            start_artilley = end;
            rotationX = mImgArtillery.getRotation();
            final float angle = (float) Math.toDegrees(Math.atan2(downX - mWidth / 2, mHeight - downY));


            if (angle >= -60 && angle <= 60) {
                mImgArtillery.setPivotX(mImgArtillery.getWidth() / 2);
                mImgArtillery.setPivotY(mImgArtillery.getHeight() - BitmapManager.getInstance().getFloatDimen(R.dimen.rotation_point));
                mImgBullet.setPivotX(mImgBullet.getWidth() / 2);
                mImgBullet.setPivotY(mImgArtillery.getHeight() + BitmapManager.getInstance().getFloatDimen(R.dimen.rotation_point_bullet));
                mImgBullet.setRotation(angle);
                normaX = -angle / 90f * 10f;
                normaY = 10f;
                if (angle < -70) {
                    normaY = 0f;
                } else if (angle > 70) {
                    normaY = 0f;
                }
                normalX = mImgArtillery.getTranslationX();
                normalY = mImgArtillery.getTranslationY();
                ObjectAnimator rotation = ObjectAnimator.ofFloat(mImgArtillery, "rotation", rotationX, angle);
                rotation.setInterpolator(new AccelerateInterpolator());
                final ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImgArtillery, "translationX", normaX, normalX);
                scaleX.setInterpolator(new AccelerateInterpolator());
                final ObjectAnimator scaleY = ObjectAnimator.ofFloat(mImgArtillery, "translationY", normaY, normalY);
                scaleY.setInterpolator(new AccelerateInterpolator());

                animator = new android.animation.AnimatorSet();
                animator2 = new android.animation.AnimatorSet();
                animator.playTogether(rotation);
                animator.setDuration(10);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        animator2.playTogether(scaleY, scaleX);
                        animator2.setDuration(100);
                        animator2.start();
                        fishNet.add(new NetFish(downX, downY));


                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                animator2.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mImgBullet.setVisibility(View.VISIBLE);
                        uiHandler.sendEmptyMessageDelayed(setBulerGoin, 100);
                        fishNet.clear();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }


        }

        for (int i = 0; i < fish.size(); i++) {
            if (fish.get(i).getTarget() != null && fish.get(i).getTarget().contains(downX, downY)) {
                fish.get(i).setMove(false);
                fish.get(i).setDisappear(true);
                Log.e(TAG, " 点中鱼了  X " + fish.get(i).typefish);
                fish.remove(i);

                startAccountCoinsAnimation(downX, downY, getmFramlayout());
            }
        }


    }

    //ui hander
    private final int setBulerGoin = 100000;

    public class UiHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100000:
                    mImgBullet.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    public void touchMove(MotionEvent ev) {

    }


    private ArrayList<ImageView> mFlyCoins = new ArrayList<>();
    private int mFlyCoinIndex = 0;

    public ImageView getFlyCoinsView() {
        mFlyCoinIndex = (mFlyCoinIndex + 1) % mFlyCoins.size();
        return mFlyCoins.get(mFlyCoinIndex);
    }

    public ImageView createCoinsView() {
        ImageView coinView = new ImageView(context);

        coinView.setImageResource(R.mipmap.fishing_joy_under_gold);


        coinView.setScaleType(ImageView.ScaleType.FIT_XY);
        coinView.setVisibility(View.INVISIBLE);
        return coinView;
    }

    public long startAccountCoinsAnimation(float startX, float startY/*, float endX, float endY,*/, FrameLayout flyStageLayout) {


        for (int i = 0; i < 6; i++) {
            mFlyCoins.add(createCoinsView());
        }
        for (int i = 0; i < 6; i++) {
            final ImageView coinsView = getFlyCoinsView();

            coinsView.clearAnimation();
            coinsView.invalidate();

            flyStageLayout.removeView(coinsView);

            FrameLayout.LayoutParams param = new FrameLayout.LayoutParams((int)BitmapManager.getInstance().getFloatDimen(R.dimen.flygoldwh), (int)BitmapManager.getInstance().getFloatDimen(R.dimen.flygoldwh));
            param.setMargins((int) (startX + 9), (int) startY, 0, 0);
            coinsView.setImageResource(R.mipmap.fishing_joy_under_gold);
            flyStageLayout.addView(coinsView, param);

            TranslateAnimation translateAnimation = new TranslateAnimation(0, BitmapManager.getInstance().getFloatDimen(R.dimen.flygold_x)
                    - startX, 0, BitmapManager.getInstance().getFloatDimen(R.dimen.flygold_y) - startY); //平移动画
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 1.0f);
            AnimationSet set = new AnimationSet(true);
            set.addAnimation(alphaAnimation);
            set.addAnimation(translateAnimation);
            set.setDuration(800);
            set.setStartOffset(90 * i);
            coinsView.startAnimation(set);
            coinsView.setVisibility(View.INVISIBLE);

        }

        return 90 * 6 + 800;
    }

    public ImageView getmImgArtillery() {
        return mImgArtillery;
    }

    public void setmImgArtillery(ImageView mImgArtillery) {
        this.mImgArtillery = mImgArtillery;
    }

    public ImageView getmImgBullet() {
        return mImgBullet;
    }

    public void setmImgBullet(ImageView mImgBullet) {
        this.mImgBullet = mImgBullet;
    }

    public FrameLayout getmFramlayout() {
        return mFramlayout;
    }

    public void setmFramlayout(FrameLayout mFramlayout) {
        this.mFramlayout = mFramlayout;
    }


}
