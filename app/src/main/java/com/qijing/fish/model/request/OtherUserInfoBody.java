package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *  粉丝关注 和取消关注
 */

public class OtherUserInfoBody extends BaseBody{


    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "user.direct";
        baseModuleRequset.qModel = "baseinfo";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "user";
        baseModel.aParam = "otherUserInfo";
        return baseModel;
    }

    @Override
    public BaseBean CreateBaseBean(BaseBean baseBean) {
        return baseBean;
    }

    public BaseBean CreateOtherInfoBean(String userId) {
        BaseBean baseBean = new OtherInfo(userId);
        return baseBean;
    }

    private class OtherInfo extends BaseBean {
        @SerializedName("u")
        public String userId;

        public OtherInfo(String userId) {
            this.userId = userId;
        }
    }

}
