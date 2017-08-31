package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *  粉丝关注 和取消关注
 */

public class FansConcerBody extends BaseBody{

    /**
     *     粉丝关注
     *             e：固定填fans.direct
     *             q：固定填fans
     */
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "fans.direct";
        baseModuleRequset.qModel = "fans";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    /**
     *         d.t：用户token值
     *         d.a：固定填  关注concern    //    取消关注cancel_concern
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        return baseModel;
    }

    public BaseModel CreateFansModel(boolean concern) {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        if (concern) {
            baseModel.aParam = "concern";
        }else {
            baseModel.aParam = "cancel_concern";
        }
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
    public static class FansBean extends BaseBean{
        @SerializedName("b")
        public String userId;

        public FansBean(String userId) {
            this.userId = userId;
        }
    }

}
