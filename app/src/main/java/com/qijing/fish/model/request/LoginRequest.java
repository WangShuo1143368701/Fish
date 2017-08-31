package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * 用户登录请求传递参数
 */

public class LoginRequest extends BaseRequest{
    /**用户登录ID**/
    @SerializedName("a")
    public String loginId;
    /**手机设备号**/
    @SerializedName("d")
    public String deviceCode;
    /**用户类型**/
    @SerializedName("t")
    public String userType;
    /**用户设备类型**/
    @SerializedName("p")
    public String phoneType;
    /**当前版本号**/
    @SerializedName("v")
    public String currentVersion;
    /**当前用户名称**/
    @SerializedName("n")
    public String userName;
    /**当前网络类型**/
    @SerializedName("w")
    public String netType;
    /**手机屏幕的宽度**/
    @SerializedName("x")
    public String phoneWidth;
    /**手机屏幕的高度**/
    @SerializedName("y")
    public String phoneHeight;
    /****/
    @SerializedName("b")
    public String buildModel;
    /**手机屏幕的高度**/
    @SerializedName("o")
    public String sdkInt;
    /**当前时间**/
    @SerializedName("m")
    public String currentTime;

}
