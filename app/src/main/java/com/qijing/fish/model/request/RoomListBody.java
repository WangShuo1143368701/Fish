package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by czl on 2017/6/28.
 *  获取用户房间列表
 */

public class RoomListBody extends BaseBody{

    /**
     *                      拉房间列表接口(App调用)
     *                     {"e":"php.room.direct", "q":"php_room","d":{"k":"token","a":"get_room_list", "l":["room_id", "room_id", ..., "room_id"]}, "v":"shuffling_version"}
     *                       e：固定填php.room.direct
     *                       q：固定填php_room
     *                       d.t：用户token值
     *                       d.a：固定填 get_room_list
     *                       d.l: 客户端已经拥有的房间id列表
     *                       d.v: 客户端的轮波图版本号(16位md5)
     */
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "php.room.direct";
        baseModuleRequset.qModel = "php_room";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }
    /**
     *                   首页轮播接口（APP调用）
     *                   请求：{"e":"php.room.direct", "q":"php_room","d":{"k":"token","c":"room","a":"shuffling"}}
     *                  e：固定填php.room.direct
     *                  q：固定填php_room
     *                  d.t：用户token值
     *                  d.a：固定填shuffling
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "room";
        baseModel.aParam = "shuffling";
        return baseModel;
    }

    /**
     *         获取房间列表
     * @param roomIdLists
     * @return
     */
    public BaseModel CreateBaseModel(ArrayList<RoomId>roomIdLists, String verson) {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "get_room_list";
        baseModel.version = verson;
        baseModel.baseBeans = new ArrayList<>();
        baseModel.baseBeans.addAll(roomIdLists);
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
     *  房间列表ID
     */
    public static class RoomId extends BaseBean{
        @SerializedName("i")
        public String roomId;
        public RoomId(String roomId) {
            this.roomId = roomId;
        }
    }

}
