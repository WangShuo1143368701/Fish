package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/30.
 * 首页轮播列表
 *
 *
 */

public class RoomBannerRespone {
    /**
     *    轮播的图片
     */
    @SerializedName("a")
    public String roomBannerIcon;
    /**
     *    跳转的URL
     */
    @SerializedName("b")
    public String roomBannerUrl;
    /**
     *    跳转的类型
     */
    @SerializedName("c")
    public String roomBannerType;
}
