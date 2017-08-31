package com.qijing.fish.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.qijing.fish.GameSurfaceView;
import com.qijing.fish.R;

/**
 * Created by User on 2017/8/10.
 */

public class FinshGameView extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private GameSurfaceView gameSurfaceView;

    //    private GameMenuView gameMenuView;
    private FrameLayout mFramlayout;
    public ImageView mImg_Artillery;
    public ImageView mImg_Bulletl;
    private ImageView mImg_Joyodd;

    public FinshGameView(Context context) {
        super(context);
        init(context);
    }

    public FinshGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FinshGameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;

        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.game_view, this);
        gameSurfaceView = (GameSurfaceView) findViewById(R.id.gameSurfaceView);
        mImg_Artillery = (ImageView) findViewById(R.id.img_artillery);
        mImg_Bulletl = (ImageView) findViewById(R.id.img_bullet);
        mImg_Joyodd = (ImageView) findViewById(R.id.img_joyodd);
        ;
        mFramlayout = (FrameLayout) findViewById(R.id.frm_fly_money);
        gameSurfaceView.setmImgArtillery(mImg_Artillery);
        gameSurfaceView.setmImgBullet(mImg_Bulletl);
        gameSurfaceView.setmFramlayout(mFramlayout);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
