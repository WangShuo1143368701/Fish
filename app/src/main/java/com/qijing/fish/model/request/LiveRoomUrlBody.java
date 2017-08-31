package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *  获取推流地址
 *  {"e":"bm.direct", "q":"bmanager", "d":{"k":"token", "a":"get_room_url", "p":{"r":"room_id"}}}
 */

public class LiveRoomUrlBody extends BaseBody{

    /**
     *   e: 固定填 bm.direct
         q: 固定填  bmanager
         d.k: token
         d.a: 固定填 get_room_url
         d.p.r : 房间ID
     */
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "bm.direct";
        baseModuleRequset.qModel = "bmanager";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
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
        baseModel.aParam = "get_room_url";
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
     *         请求的实体类
     * @param id  房间ID
      * @return
     */

    public BaseBean CreateBaseBean(String id) {
        BaseBean roomId = new RoomId(id);
        return roomId;
    }

    private class RoomId extends BaseBean{
        @SerializedName("r")
        private String roomId;

        public RoomId(String roomId) {
            this.roomId = roomId;
        }
    }
}
