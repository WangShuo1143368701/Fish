package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/5.
 */

public class SmsChannelMoneyRespone {
//    响应：{"r":0,"p":[{"i":"goods_id","c":"raw_coins_count","m":"image_id","b":"buy_coins_count","d":"discount_info","p":"price"},
//    r : 0 成功
//    p[0].i ：商品ID
//    p[0].m : 商品金币图片ID
//    p[0].c : 原来可购买金币数
//    p[0].b : 实际购买金币数
//    p[0].d : 折扣信息
//    p[0].p : 商品展示价格
    /****商品ID***/
    @SerializedName("i")
    public String goodsId;
    /****商品金币图片ID***/
    @SerializedName("m")
    public int imageId;
    /****原来可购买金币数***/
    @SerializedName("c")
    public String rawCoinsCount;
    /****商品ID***/
    @SerializedName("b")
    public String buyCoinsCount;
    /****商品ID***/
    @SerializedName("d")
    public String discountInfo;
    /****商品ID***/
    @SerializedName("p")
    public String price;

}
