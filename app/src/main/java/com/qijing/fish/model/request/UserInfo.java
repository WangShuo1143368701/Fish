package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/27.
 */

public class UserInfo extends BaseBean{
    /**
     *  用户头像
     */
    @SerializedName("i")
    public String userImage;
}
