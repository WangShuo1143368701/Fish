package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/22.
 */

public class LiveFreecoinsRespone {
    /**
     * 2.2、 fcoins_status ，获取免费金币状态标示，宝箱展示接口 (APP调用接口)
     请求：{"e":"freecoins.direct", "q":"freecoins", "d":{"k":"token", "a":"fcoins_status"} }

     响应：{"r":"result", "p":{"s":"free_coins_available_status"}}
     p.s : 是否存在可以领取的任务奖励, 组合标志位
     enum FCoinsStatus
     {
     free_coins_register = 0x0001,  // 注册奖励
     free_coins_active	= 0x0002,  // 活跃登陆奖励
     free_coins_task		= 0x0004,  // 任务（礼物或者游戏）
     free_coins_box		= 0x0008,  // 倒计时宝箱（暂时未实现）
     };
     * @return
     */

    /**礼物ID**/
    @SerializedName("s")
    public String freecoinsType;

}
