package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/3.
 */

public class RankingListRespone {
//    p.a ：用户ID
//    p.b ：昵称
//    p.d ：头像
//    p.s : 性别 0:男；1：女；2：其它
//    p.f ：等级
//    p.g ：积分
//    p.r : 排名 （自己的排名若为0，表示不在榜内）
//    p.t ：魅力值
//    p.m ：粉丝数量
//    p.n ：本用户是否关注了该用户 0/未关注 1/已关注

//
//    p : 排行榜列表 (第一条是用户自己的排名信息）
//            p.a : 用户ID
//            p.b : 昵称
//            p.d : 头像
//            p.s : 性别 0:男；1：女；2：其它
//            p.f : 等级
//            p.g : 积分
//            p.r : 排名 （自己的排名若为0，表示不在榜内）
//            p.m : 粉丝数量
//            p.n : 本用户是否关注了该用户 0/未关注 1/已关注
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
    @SerializedName("n")
    public String userFollow;
    /**用户魅力值**/
    @SerializedName("t")
    public String userCharm;



}
