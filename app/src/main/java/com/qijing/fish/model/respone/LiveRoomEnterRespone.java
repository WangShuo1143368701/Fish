package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 *        p.a : 是否是房管
 *        p.m : 用户是否是超级管理员
 *        p.s : 系统封号标志位； 数字为十进制，但要按二进制取比特位来获取标志信息；十六进制分别表示如下（不懂就问）：  0x01 : 封号； 0x02 : 封头像； 0x04 : 封封面； 0x08 : 全服禁言
 *        p.r : 房间禁言标志位；  0：未禁言； 1：禁言；
 *        p.c : 用户是否关注了该房间，是否是该主播的粉丝；  0:未关注； 1：已关注
 *        p.o : 房间当前在线人数
 *        p.w : 房间主播魅力值
 *        p.l : 房间的拉流地址
 *        p.n ：房间的主播名称
 *        p.i ：主播的头像路径
 */

public class LiveRoomEnterRespone {
    @SerializedName("a")
    public String roomManager;
    @SerializedName("m")
    public String roomRoot;
    @SerializedName("s")
    public String roomFlag;
    @SerializedName("r")
    public String roomGagr;
    @SerializedName("c")
    public String roomAttent;
    @SerializedName("o")
    public String roomOnline;
    @SerializedName("w")
    public String roomCharm;
    @SerializedName("l")
    public String roomUrl;
    @SerializedName("n")
    public String roomName;
    @SerializedName("i")
    public String roomIcon;
}
