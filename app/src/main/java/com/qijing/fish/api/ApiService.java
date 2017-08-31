package com.qijing.fish.api;


import com.qijing.fish.model.respone.BaseRespone;
import com.qijing.fish.model.respone.GameFishRespone;
import com.qijing.fish.model.respone.LiveActiveLoginRespone;
import com.qijing.fish.model.respone.LiveAnchorRespone;
import com.qijing.fish.model.respone.LiveFreecoinsRespone;
import com.qijing.fish.model.respone.LiveGiftRespone;
import com.qijing.fish.model.respone.LiveRoomEnterRespone;
import com.qijing.fish.model.respone.LiveRoomGiftRespone;
import com.qijing.fish.model.respone.LiveRoomUrlRespone;
import com.qijing.fish.model.respone.LoginRespone;
import com.qijing.fish.model.respone.OtherUserInfoRerspon;
import com.qijing.fish.model.respone.RankingListRespone;
import com.qijing.fish.model.respone.RoomBannerRespone;
import com.qijing.fish.model.respone.RoomListRespone;
import com.qijing.fish.model.respone.SmsChannelMoneyRespone;
import com.qijing.fish.model.respone.SmsChannelRespone;
import com.qijing.fish.model.respone.SmsChargeRespone;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;


/**
 * 请求的相关接口
 */
public interface ApiService {

    /**
     *  用户登录接口
     * @param data
     * @return
     */
    @POST("login")
    Observable<BaseRespone<LoginRespone>> login(@Body String data);
    /**
     *  修改用户信息
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone> changeUserInfo(@Url String url, @Body String data);
    /**
     *  获取首页直播列表
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<RoomListRespone>> getRoomList(@Url String url, @Body String data);

    /**
     *  获取首页轮播列表
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<RoomBannerRespone>> getRoomBannerList(@Url String url, @Body String data);
    /**
     *  获取排行榜列表
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<RankingListRespone>> getRankingList(@Url String url, @Body String data);

    /**
     *           粉丝关注和取消关注
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<RankingListRespone>> fansConcerned(@Url String url, @Body String data);
    /**
     *           获取支付渠道相关信息
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<SmsChannelRespone>> getChannelList(@Url String url, @Body String data);
    /**
     *           获取支付渠道支付金额列表
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<SmsChannelMoneyRespone>> getChannelMoneyList(@Url String url, @Body String data);
    /**
     *           获取支付渠道的支付订单号
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<SmsChargeRespone>> getPayOrderId(@Url String url, @Body String data);

    /**
     *           获取直播拉流地址
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveRoomUrlRespone>> getRoomPullUrl(@Url String url, @Body String data);

    /**
     *           获取礼物列表信息
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveGiftRespone>> getGiftList(@Url String url, @Body String data);
    /**
     *           获取用户活跃进度
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveActiveLoginRespone>> getActiveLogin(@Url String url, @Body String data);
    /**
     *           获取所有的任务状态
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveFreecoinsRespone>> getAllTaskStatus(@Url String url, @Body String data);
    /**
     *           用户加入房间请求
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveRoomEnterRespone>> getEnterRoom(@Url String url, @Body String data);
    /**
     *           用户离开房间请求
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone> getExitRoom(@Url String url, @Body String data);
    /**
     *           用户发送消息
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone> sendChatMessage(@Url String url, @Body String data);
    /**
     *           用户在房间刷礼物
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveRoomGiftRespone>> sendRoomGift(@Url String url, @Body String data);


    /**
     *             主播 申请开播
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<LiveAnchorRespone>> requestLiveOpen(@Url String url, @Body String data);

    /**
     *           获取用户信息
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<OtherUserInfoRerspon>> otherUserInfo(@Url String url, @Body String data);
    /**
     *           用户选择游戏
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone> chooseGame(@Url String url, @Body String data);



    /**
     *           请求捕鱼结果
     * @param data
     * @return
     */
    @POST
    Observable<BaseRespone<GameFishRespone>> buyu(@Url String url, @Body String data);
}
