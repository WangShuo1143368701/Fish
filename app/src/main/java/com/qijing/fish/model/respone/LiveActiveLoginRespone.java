package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/22.
 */

public class LiveActiveLoginRespone {
      /*
    *    7、active_login_progress 获取活跃登录进度 (APP调用接口)
    *
    *    请求：{"e":"freecoins.direct", "q":"freecoins", "d":{"k":"token", "a":"active_login_progress"} }
    *
    *    响应：{"r":"result", "p":{"t":"进度达成总时间", "c":"奖励金币", "l":"进度时间", "s":"活跃登录奖励状态，0没到领取时间，1可领，2今日领完了"} }
    */

    /**进度达成总时间*/
    @SerializedName("t")
    public String avtiveAllTime;
    /**奖励金币**/
    @SerializedName("c")
    public String avtiveGold;
    /**进度时间**/
    @SerializedName("l")
    public String avtiveSpeedTime;
    /**"活跃登录奖励状态，0没到领取时间，1可领，2今日领完了**/
    @SerializedName("s")
    public String avtiveStatus;
}
