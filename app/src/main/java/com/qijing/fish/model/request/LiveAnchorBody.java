package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

public class LiveAnchorBody extends BaseBody{

    /**
     *4. 用户开播 (APP调用接口)
     * {"e":"bm.direct", "q":"bmanager", "d":{"k":"token", "a":"open_broom", "p":{"t":"broom_type","h":"room_title"}}}
     *   e: 固定填 bm.direct
         q: 固定填  bmanager
         d.k: token
         d.a: 固定填 open_broom
         d.p : 参数
         d.p.t :  可选参数， 直播间类型
         d.p.h :  可选参数， 直播间标题
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
        baseModel.aParam = "open_broom";
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
     * @param title  房间ID
      * @return
     */

    public BaseBean CreateBaseBean(String title) {
        BaseBean roomId = new RoomId(title);
        return roomId;
    }

    private class RoomId extends BaseBean{
        @SerializedName("h")
        private String liveTitle;
        @SerializedName("t")
        private String liveType;
        public RoomId(String liveTitle) {
            this.liveTitle = liveTitle;
        }
    }

    /**
     * 7.1. 获取推流地址 (APP调用接口)
     */
    public BaseModel CreatePushUrlModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "get_push_url";
        return baseModel;
    }

    /**
     *        房间里面选择游戏开播
     * @return
     * @param roomId
     */

    public BaseModuleRequset CreateChooseGameRequest(String roomId) {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = roomId;
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }


    public BaseModel CreateChooseGameModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "game_select";
        return baseModel;
    }

    public BaseBean CreateChooseGameBean(String gameType) {
        BaseBean baseBean = new ChooseGame(gameType);
        return baseBean;
    }

    private class ChooseGame extends BaseBean {
        @SerializedName("t")
        public String game_type;

        public ChooseGame(String game_type) {
            this.game_type = game_type;
        }
    }
}
