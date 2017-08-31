package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by czl on 2017/7/3.
 */

public class GameFishRespone {

    /* 用户 p.l 当前金币数量*/
    @SerializedName("l")
    public String leftcoins;
    /* p.w 赢取的金币数量*/
    @SerializedName("w")
    public String wincount;
    /*捕鱼结果数组*/
    @SerializedName("f")
    private List<FishResult> fish_result;

    public class FishResult {
        /*鱼的ID*/
        @SerializedName("i")
        private int fishid;
        /*是否捕捉成功， 1 : 成功， 0 ： 失败*/
        @SerializedName("s")
        private int success;
        /*鱼的种类*/
        @SerializedName("t")
        private int type;

        @Override
        public String toString() {
            return "FishResult:{ " +
                    " fishid:" + fishid +
                    ", success:" + success +
                    ", type:" + type +
                    '}';
        }
    }

    private FishResult fishResult=null;

    private FishResult getFishResult(){
        if(fishResult==null){
            fishResult=new  FishResult();
        }
        return fishResult;
    }
    @Override
    public String toString() {
        return "GameFishRespone:{" +
                " leftcoins:" + leftcoins +
                ", wincount:" + wincount +
                ", " + getFishResult().toString() +

                '}';
    }
}

