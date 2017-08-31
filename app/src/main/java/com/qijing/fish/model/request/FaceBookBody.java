package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 * 用户使用facebook登录之后  上传用户图片信息
 */

public class FaceBookBody extends BaseBody{

    /***
     *   第一层参数 e  user.direct  交换器
     *              q  baseinfo     路由
     *              n   自增序列
     *
     * @return  第一层数据
     */
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "user.direct";
        baseModuleRequset.qModel = "baseinfo";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    /**
     *         第二层参数 k   baseModel.token    token
     * @return           c   baseModel.user     暂停使用
     *                    a   baseModel.charm    接口名称
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "user";
        baseModel.aParam = "updateBaseinfo";
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

    private class FaceBoookModel extends BaseModel{
        /**用户toket**/
        @SerializedName("k")
        public String token;
        /** user**/
        @SerializedName("c")
        public String user;
        /**用户修改的属性**/
        @SerializedName("a")
        public String changeType;
    }

//    public class UserBena extends BaseBean{
//        /**
//         *  用户头像
//         */
//        @SerializedName("i")
//        public String userImage;
//    }

}
