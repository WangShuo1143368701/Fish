package com.qijing.fish;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;


/**
 * Created by User on 2017/8/8.
 */

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private final String TAG = GameSurfaceView.class.getSimpleName();
    private SurfaceHolder surfaceHolder;
    private Thread drawThread;
    private static final long FPS = 60;
    public GameScene gameScene;
    private Context context;
    private boolean flag;
    private ImageView mImgArtillery;
    private FrameLayout mFramlayout;

    private ImageView mImgBullet;
    public GameSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public GameSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
//        this.setZOrderOnTop(true);
//        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);

        if (gameScene == null) {
            gameScene = new GameScene(context);
        }
    }

//    private Thread updateThread = new Thread(new Runnable() {
//
//        @Override
//        public void run() {
//            while(!flag){
//                try {
//                    Thread.sleep(FPS);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    });


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG," getMeasuredWidth "+getMeasuredWidth());
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        gameScene.load();
        flag = false;
        drawThread = new Thread(this);
        drawThread.start();

//        updateThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = true;
        drawThread.interrupt();
    }

    private long current;
    private Canvas canvas;

    @Override
    public void run() {
//        Looper.prepare();
//        renderHandler = new RenderHandler();
//        renderHandler.sendEmptyMessage(0);
//        Looper.loop();
        while(!flag){
            long start = System.currentTimeMillis();
            draw();
            long end = System.currentTimeMillis();
            current = end - start;
            if(end - start <FPS){
                try {
                    Thread.sleep(FPS-current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void draw() {
        try {
            canvas = getHolder().lockCanvas();
            if (canvas != null) {
                if (gameScene != null)
                    gameScene.draw(canvas);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null)
                getHolder().unlockCanvasAndPost(canvas);
        }
    }



//    private float downX, downY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        downX = event.getX();
//        downY = event.getY();

        if (gameScene == null)
            return true;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                gameScene.touchDown(event);
                break;
            case MotionEvent.ACTION_UP:
                gameScene.touchUp(event);
                break;
            case MotionEvent.ACTION_MOVE:
                gameScene.touchMove(event);
                break;
        }
        return true;
    }

    //退出游戏
    private void exitGame(){
//        renderHandler.sendEmptyMessage(1);
        flag = true;
        drawThread.interrupt();
    }


    public ImageView getmImgArtillery() {
        return mImgArtillery;
    }

    public void setmImgArtillery(ImageView mImgArtillery) {

        gameScene.setmImgArtillery(mImgArtillery);
        this.mImgArtillery = mImgArtillery;
    }

    public ImageView getmImgBullet() {
        return mImgBullet;
    }

    public void setmImgBullet(ImageView mImgBullet) {
        gameScene.setmImgBullet(mImgBullet);
        this.mImgBullet = mImgBullet;
    }


    public FrameLayout getmFramlayout() {
        return mFramlayout;
    }

    public void setmFramlayout(FrameLayout mFramlayout) {
        gameScene.setmFramlayout(mFramlayout);
        this.mFramlayout = mFramlayout;
    }



}
