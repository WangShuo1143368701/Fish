package com.qijing.fish.entity.ui;

import com.qijing.fish.base.BaseFish;

import java.util.Vector;

/**
 * Created by User on 2017/8/8.
 */

public class FishFactory {
    public static Vector<BaseFish> vec = new Vector<BaseFish>(); // Vector对象用于存放所有组件
    private BaseFish fish;

    public BaseFish oncreate(int type, int track) {
        switch (type) {
            case 1:
                fish = new SharkFish(1, track);
                break;
            case 2:
                fish = new SquidFish(2, track);
                break;
            case 3:
            case 4:
            case 5:
                fish = new OneFish(3, track);
                break;
            case 6:
            case 7:
            case 8:
                fish = new TwoFish(4, track);
                break;
            case 9:
            case 10:
            case 11:
                fish = new ThreeFish(5, track);
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                fish = new FourFish(6, track);
                break;
            case 30:
                fish = new PaoPao(type, track);
                break;
        }
        return fish;
    }


}
