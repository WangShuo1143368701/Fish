package com.qijing.fish;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by User on 2017/8/8.
 */

public class BitmapManager {
    private final String TAG = BitmapManager.class.getSimpleName();
    private static BitmapManager instance;
    public Bitmap bg;//背景
    public Bitmap artilley;//大炮

    public Bitmap dapao;//大炮

    public Bitmap gunpad;//大炮
    private Context context;

    private BitmapManager() {
    }

    public static BitmapManager getInstance() {
        if (instance == null)
            instance = new BitmapManager();
        return instance;
    }

    //声明元素所需要的图片
    private static final int[] hsy = new int[]{R.mipmap.hsy00, R.mipmap.hsy01, R.mipmap.hsy02,
            R.mipmap.hsy03, R.mipmap.hsy04, R.mipmap.hsy05, R.mipmap.hsy06, R.mipmap.hsy07,
            R.mipmap.hsy08, R.mipmap.hsy09, R.mipmap.hsy10};

    private static final int[] bwy = new int[]{R.mipmap.bwy01, R.mipmap.bwy02, R.mipmap.bwy03,
            R.mipmap.bwy04, R.mipmap.bwy05, R.mipmap.bwy06, R.mipmap.bwy07, R.mipmap.bwy08,
            R.mipmap.bwy09, R.mipmap.bwy10};


    private static final int[] xhy = new int[]{R.mipmap.xhy01, R.mipmap.xhy02, R.mipmap.xhy03,
            R.mipmap.xhy04, R.mipmap.xhy05, R.mipmap.xhy06, R.mipmap.xhy07, R.mipmap.xhy08,
            R.mipmap.xhy09, R.mipmap.xhy10
    };
    private static final int[] syh = new int[]{R.mipmap.shy1, R.mipmap.shy2, R.mipmap.shy3,
            R.mipmap.shy4, R.mipmap.shy5, R.mipmap.shy6, R.mipmap.shy7, R.mipmap.shy8, R.mipmap.shy9,
            R.mipmap.shy10,
    };

    private static final int[] sy = new int[]{R.mipmap.sy01, R.mipmap.sy02, R.mipmap.sy03,
            R.mipmap.sy04, R.mipmap.sy05, R.mipmap.sy06, R.mipmap.sy07, R.mipmap.sy08,
    };

    private static final int[] sby = new int[]{R.mipmap.sby1, R.mipmap.sby2, R.mipmap.sby3,
            R.mipmap.sby4, R.mipmap.sby5, R.mipmap.sby6, R.mipmap.sby7, R.mipmap.sby8, R.mipmap.sby9,
            R.mipmap.sby10,
    };


    public List<Bitmap> hsys;//鱼
    public List<Bitmap> bwys;//鱼
    public List<Bitmap> xhys;//鱼
    public List<Bitmap> syhs;//鱼


    public List<Bitmap> sys;//鲨鱼
    public List<Bitmap> sbys;//鱼

    public Bitmap fishNetBit; //渔网


    public Bitmap PaoPao;//泡泡
    public int displayWidth, displayHeight;
    public int heigthGroup;//游戏容器的高度

    public List<Integer> allFish;

    public void init(Context context) {
        this.context = context;
    }

    //加载资源
    public void loadResources() {

        //获取当前手机分辨率
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        displayWidth = wm.getDefaultDisplay().getWidth();
        displayHeight = wm.getDefaultDisplay().getHeight();
        //定义当前游戏容器的高度
        heigthGroup = getIntDime(R.dimen.game_height);

        bg = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_bg);

        PaoPao = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_bubble);

        artilley = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_cannon_11);
        dapao = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_cannon_11);

        gunpad = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_cannon_chassis_3);

        fishNetBit = BitmapUtil.getInstance().loadResource(context, R.mipmap.fishing_joy_nets);

        hsys = new ArrayList<Bitmap>();//鱼
        bwys = new ArrayList<Bitmap>();//鱼
        xhys = new ArrayList<Bitmap>();//鱼
        syhs = new ArrayList<Bitmap>();//鱼

        sys = new ArrayList<Bitmap>();//鲨鱼
        sbys = new ArrayList<Bitmap>();//魔鬼

        for (int res : hsy) {
            hsys.add(BitmapFactory.decodeResource(context.getResources(), res));
        }
        for (int res : bwy) {
            bwys.add(BitmapFactory.decodeResource(context.getResources(), res));
        }
        for (int res : xhy) {
            xhys.add(BitmapFactory.decodeResource(context.getResources(), res));
        }
        for (int res : syh) {
            syhs.add(BitmapFactory.decodeResource(context.getResources(), res));
        }

        for (int res : sy) {
            sys.add(BitmapFactory.decodeResource(context.getResources(), res));
        }
        for (int res : sby) {
            sbys.add(BitmapFactory.decodeResource(context.getResources(), res));
        }


        oncreateFish();

    }

    private Random rad = new Random();

    private void oncreateFish() {
        allFish = new ArrayList<Integer>();
        allFish.clear();

        allFish.add(1);
        for (int i = 1; i < 15; i++) {
            int type = Math.abs(rad.nextInt(15) + 1);
            if (type != 1) {
                allFish.add(type);
            } else {
                allFish.add(type + 1);
            }

        }
    }

    public int randomAddFish() {
        int type = Math.abs(rad.nextInt(15) + 1);
        if (type != 1) {
            return type;
        } else {
            return type + 1;
        }
    }


    //
    public int getIntDime(int res) {

        return (int) context.getResources().getDimension(res);
    }


    public float getFloatDimen(int res) {

        return context.getResources().getDimension(res);
    }

}
