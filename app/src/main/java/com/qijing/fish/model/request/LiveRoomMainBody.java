package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *
 *    用户直播间相关逻辑
 *
 *
 */

public class LiveRoomMainBody extends BaseBody{

    /**
     *
     * 礼物商城商品列表
         @param {"e":"php.goods.direct", "q":"php_goods","d":{"k":"token","c":"goods","a":"gList"}}
     *   @return
        {"r":"0","p":[{"a":"100","b":"1","c":"\\u6ce2\\u677f\\u7cd6","g":"10","k":"10042.png","i":"100","n":"0","l":"999","m":"charm_increase"},
        {"a":"101","b":"1","c":"\\u73ab\\u7470\\u82b1","g":"20","k":"10114.png","i":"100","n":"0","l":"999","m":"charm_increase"},
        {"a":"123","b":"2","c":"\\u6d77\\u5c9b","g":"99999","k":"12308.png","i":"100","n":"1","l":"999","m":"charm_increase"}]}
        p.a : '礼物ID',
        p.b : '礼物类型，1：连击礼物；2：全屏礼物；'
        p.c : '礼物在礼物列表展示名称',
        p.g : 消耗的金币数量
        p.k : 礼物图片
        p.n : 是否是积分礼物  0：不是 1：是
        p.i : 礼物积分
        p.l : 商城的特殊显示标签 0/没有 1/hot 2/new
        p.m : 礼物增加的魅力值
     *
     */
    public BaseModuleRequset CreateGiftListRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "php.goods.direct";
        baseModuleRequset.qModel = "php_goods";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    public BaseModel CreateGiftListModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "goods";
        baseModel.aParam = "gList";
        return baseModel;
    }

    /*
    *    7、active_login_progress 获取活跃登录进度 (APP调用接口)
    *
    *    请求：{"e":"freecoins.direct", "q":"freecoins", "d":{"k":"token", "a":"active_login_progress"} }
    *
    *    响应：{"r":"result", "p":{"t":"进度达成总时间", "c":"奖励金币", "l":"进度时间", "s":"活跃登录奖励状态，0没到领取时间，1可领，2今日领完了"} }
    */
    public BaseModuleRequset CreateActiveLoginRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "freecoins.direct";
        baseModuleRequset.qModel = "freecoins";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }
    public BaseModel CreateActiveLoginModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "active_login_progress";
        return baseModel;
    }
    /**
     *
     * {"d":{"a":"enter_broom","k":","c":""},"e":"broom.direct","n":"4","q":"bmanager"}
     *
     *   2. 用户进入房间 (APP调用接口)
     {"e":"broom.direct", "q":"bmanager", "d":{"k":"token", "a":"enter_broom", "p":{"r":"room_id"}}}

     e: 固定填 broom.direct
     q: 固定填 bmanager
     d.k: token
     d.a: 固定填 enter_broom
     d.p.r : 要进入的房间ID
     返回值：
     {"r":"result","p":{"a":"is_room_admin","m":"is_super_admin","s":"system_forbid_flag","r":"room_forbid_flag","c":"room_concerned","o":"online_count","w":"charm_total","l":"pull_url","n":"broadcastroom_name","i":"image_url"}}
     r : 处理结果
     p.a : 是否是房管
     p.m : 用户是否是超级管理员
     p.s : 系统封号标志位； 数字为十进制，但要按二进制取比特位来获取标志信息；十六进制分别表示如下（不懂就问）：  0x01 : 封号； 0x02 : 封头像； 0x04 : 封封面； 0x08 : 全服禁言
     p.r : 房间禁言标志位；  0：未禁言； 1：禁言；
     p.c : 用户是否关注了该房间，是否是该主播的粉丝；  0:未关注； 1：已关注
     p.o : 房间当前在线人数
     p.w : 房间主播魅力值
     p.l : 房间的拉流地址
     p.n ：房间的主播名称
     p.i ：主播的头像路径
     */
    public BaseModuleRequset CreateEnterRoomRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = "bmanager";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }
    public BaseModel CreateEnterRoomModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "enter_broom";
        return baseModel;
    }

    public BaseBean CreateEnterRoomBean(String id) {
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

   /*
    *
    *    4. 用户离开房间 (APP调用接口)
    *   {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"quit_broom"}}
    */
   public BaseModuleRequset CreateExitRoomRequest(String roomId) {
       BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
       baseModuleRequset.eModel = "broom.direct";
       baseModuleRequset.qModel = roomId;
       baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
       return baseModuleRequset;
   }

    public BaseModel CreateExitRoomeModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "quit_broom";
        return baseModel;
    }

    /**
     *   12. 用户刷新房间信息， 用于主播或观看重连进入房间(APP调用接口)
     *   {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"flush_broom"}}
     *    e: 固定填 broom.direct
     *    q: 填要离开的房间ID，也就是主播的用户ID
     *    d.k: token
     *    d.a: 固定填 flush_broom
     *    返回值：
     *    {"r":"result"}
     *    r : 处理结果
     */
    public BaseModuleRequset CreateFlushRoomRequest(String roomId) {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = roomId;
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }
    public BaseModel CreateFlushRoomModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "flush_broom";
        return baseModel;
    }

    /**
     * 2.2、 fcoins_status ，获取免费金币状态标示，宝箱展示接口 (APP调用接口)
     请求：{"e":"freecoins.direct", "q":"freecoins", "d":{"k":"token", "a":"fcoins_status"} }

     响应：{"r":"result", "p":{"s":"free_coins_available_status"}}
     p.s : 是否存在可以领取的任务奖励, 组合标志位
     enum FCoinsStatus
     {
     free_coins_register = 0x0001,  // 注册奖励
     free_coins_active	= 0x0002,  // 活跃登陆奖励
     free_coins_task		= 0x0004,  // 任务（礼物或者游戏）
     free_coins_box		= 0x0008,  // 倒计时宝箱（暂时未实现）
     };
     * @return
     */
    public BaseModuleRequset CreateFreecoinsRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "freecoins.direct";
        baseModuleRequset.qModel = "freecoins";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    public BaseModel CreateFreecoinsModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "fcoins_status";
        return baseModel;
    }

    /***
     *
     *          8. 用户发言 (APP调用接口)
             {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"chat", "p":{"c":"chat_content"}}}
             e: 固定填 broom.direct
             q: 填要离开的房间ID，也就是主播的用户ID
             d.k: token
             d.a: 固定填 chat
             d.p.c : 聊天内容
             11. 用户发弹幕 (APP调用接口)
             {"e":"broom.direct", "q":"room_id", "d":{"k":"token", "a":"pop_chat", "p":{"c":"chat_content"}}}

             e: 固定填 broom.direct
             q: 填要离开的房间ID，也就是主播的用户ID
             d.k: token
             d.a: 固定填 pop_chat
             d.p.c : 聊天内容
         {"r":"result"}
         r : 处理结果, 如果处理结果为该用被禁言，APP必须保存状态，后续直接不提交聊天
     *
     * @return
     */
    public BaseModuleRequset CreateChatRequest(String roomId) {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = roomId;
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    public BaseModel CreateChatModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "chat";
        return baseModel;
    }

    public BaseModel CreatePopChatModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "pop_chat";
        return baseModel;
    }

    public BaseBean CreateChatBean(String content) {
        BaseBean chatBean = new ChatBean(content);
        return chatBean;
    }

    private class ChatBean extends BaseBean{
        public ChatBean(String chatContent) {
            this.chatContent = chatContent;
        }
        @SerializedName("c")
        private String chatContent;
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
        return baseModel;
    }
    /**
     */
    @Override
    public BaseBean CreateBaseBean(BaseBean baseBean) {
        return baseBean;
    }
}
