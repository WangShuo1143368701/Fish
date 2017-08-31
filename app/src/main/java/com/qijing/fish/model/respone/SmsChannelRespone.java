package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/5.
 */

public class SmsChannelRespone {
    @SerializedName("n")
    public String channelName;

    /**
     *  p.b 支付商名称 1=>unipin 2=>coda  4 = mimopay
     */
    @SerializedName("b")
    public String businessName;
}
