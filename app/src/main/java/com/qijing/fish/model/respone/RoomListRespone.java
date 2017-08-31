package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;
import com.qijing.fish.model.request.RoomListBody;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by czl on 2017/6/30.
 *   首页房间列表
 */

public class RoomListRespone {
    @SerializedName("v")
    public String verson;
    /**
     * 房间ID
     */
    @SerializedName("c")
    public ArrayList<RoomListBody.RoomId>roomIds;
    /**
     * 房间详情
     */
    @SerializedName("o")
    public ArrayList<RoomInfo>roomInfos;
    /**
     * 轮播图信息
     */
    @SerializedName("s")
    public ArrayList<BannerInfo>bannerInfos;


    /*    u : 用户ID（房间ID）
        i : 房间图片
        s : 房间状态 0：未开播；1：正在直播
        l : 拉流地址
        o : 当前在线人数
        n : 用户名（主播呢称）
        h : 用户头像
        r : 直播间标题
        g : 游戏类型 0:没玩游戏 1：domino游戏 2：三张牌 3：骰子*/
    public static  class RoomInfo implements Serializable {
        @SerializedName("u")
        public String roomUserId;
        @SerializedName("i")
        public String roomIcon;
        @SerializedName("s")
        public String roomStatus;
        @SerializedName("l")
        public String roomInput;
        @SerializedName("o")
        public String roomNum;
        @SerializedName("n")
        public String roomName;
        @SerializedName("h")
        public String roomUserIcon;
        @SerializedName("r")
        public String roomTitle;
        @SerializedName("g")
        public String roomType;
    }

    public class BannerInfo implements Serializable {
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
}
