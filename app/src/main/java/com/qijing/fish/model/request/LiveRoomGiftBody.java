package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 *
 *  玩家送礼物， 全屏礼物 和连击礼物
 *
 */

public class LiveRoomGiftBody extends BaseBody{

    /**
     *  1. 用户送连击礼物 (APP调用接口)
         {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"combo_gift", "p":{"g":"gift_id"}}}
         e: 固定填 broom.direct
         q: 填要房间ID，也就是主播的用户ID
         d.k: token
         d.a: 固定填 combo_gift
         返回值：
         {"r":"result", "p":{"c":"coins_count"}}
         r : 处理结果

         13. 用户送全屏礼物 (APP调用接口)
         {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"screen_gift", "p":{"g":"gift_id"}}}

         e: 固定填 broom.direct
         q: 填要房间ID，也就是主播的用户ID
         d.k: token
         d.a: 固定填 combo_gift

         返回值：
         {"r":"result", "p":{"c":"coins_count"}}
     */


    public BaseModuleRequset CreateBaseRequest(String roomId) {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = roomId;
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    public BaseModel CreateScreenModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "screen_gift";
        return baseModel;
    }


    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        return baseModuleRequset;
    }

    /**
     *
     * @return
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "combo_gift";
        return baseModel;
    }

    /**
     *         请求的实体类
     * @param baseBean
     * @return
     */
    @Override
    public BaseBean CreateBaseBean(BaseBean baseBean) {

        return baseBean;
    }

    /**
     * @param id  礼物id
      * @return
     */

    public BaseBean CreateBaseBean(String id) {
        BaseBean roomId = new GiftId(id);
        return roomId;
    }

    private class GiftId extends BaseBean{
        @SerializedName("g")
        private String giftId;
        public GiftId(String giftId) {
            this.giftId = giftId;
        }
    }
}
