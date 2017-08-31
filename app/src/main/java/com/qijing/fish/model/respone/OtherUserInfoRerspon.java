package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 */

public class OtherUserInfoRerspon{
    /**用户ID**/
    @SerializedName("a")
    public String userId;
    /**用户昵称**/
    @SerializedName("b")
    public String userNick;
    /**用户头像**/
    @SerializedName("d")
    public String userIcon;
    /**用户性别  0:男；1：女；2：其它**/
    @SerializedName("s")
    public String userSex;
    /**用户等级**/
    @SerializedName("f")
    public String userLevel;
    /**用户积分**/
    @SerializedName("g")
    public String userIntegral;
    /**用户排行**/
    @SerializedName("r")
    public String userRank;
    /**用户粉丝**/
    @SerializedName("m")
    public String userFans;
    /**用户是否关注**/
    @SerializedName("c")
    public String userFollow;
    /**用户魅力值**/
    @SerializedName("t")
    public String userCharm;

}
