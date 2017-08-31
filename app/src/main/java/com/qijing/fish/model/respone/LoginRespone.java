package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 *   用户登录返回相关数据
 */
public class LoginRespone {
    /**
     *  用户登录的token
     */
    @SerializedName("k")
    public String token;
    /**
     *  用户的ID
     */
    @SerializedName("u")
    public String userId;
    /**
     *  注册时间
     */
    @SerializedName("r")
    public String registerTime;
    /**
     * 是否是新用户
     */
    @SerializedName("n")
    public String loginName;
    /**
     * 登录类型
     */
    @SerializedName("t")
    public String loginType;
    /**
     * 用户登录的id
     */
    @SerializedName("a")
    public String loginId;

}
