package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *  通过渠道号获取相关的订单信息
 */

public class SmsChargeBody extends BaseBody{
    /**UNIPIN PAY支付**/
    public final String TYPE_UNIPIN = "unipin_pay";
    /**COAD SMS支付**/
    public final String TYPE_CODA_SMS = "coda_sms_pay";
    /**COAD BAN支付**/
    public final String TYPE_CODA_BAN = "coda_bank_pay";
    /**MIMOPAY BAN支付**/
    public final String TYPE_MIMOPAY_ABN = "mimopay_bank";
    /**MIMOPAY BAN支付**/
    public final String TYPE_MIMOPAY_SMS = "mimopay_sms";

    /**
     *          通过渠道号来获取不同的订单
     *                             第一层参数
     *                                          e: 固定填 pay.direct
     *                                          q: 固定填  payment
     *                             第二层参数
     *                                          d.k: 固定值 token
     *                              可变参数
     *                                          d.a: 渠道号
     *                               1. unipin 支付购买商品        d.a   unipin_pay      返回  {"r":"result","p":{"u":"payment_url"}}
     *                               1. coda SMS 支付购买商品      d.a   coda_sms_pay    返回  {"r":"result","p":{"a":"api_key","e":"api_env","a":"order_id"}}
     *                               1. coda BANK 支付购买商品     d.a   coda_bank_pay   返回  {"r":"result","p":{"u":"payment_url"}}
     *                               1. mimopay BANK 支付购买商品  d.a   mimopay_bank    返回  {"r":"result","p":{"u":"payment_url"}}
     *                               1. minopay SMS 支付购买商品   d.a   mimopay_sms     返回  {"r":"result","p":{"t":"transition id", "c":"merchantCode", "n":"productName", "k":"staging key", "g":"gateway key"}}
     *                              第三层参数
     *                                                             d.p.n :  渠道名称
     *                                                             d.p.g :  商品ID
     *                                                             d.p.p :  平台ID  0:android ; 1:IOS
     * @return
     */

    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "pay.direct";
        baseModuleRequset.qModel = "payment";
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
        baseModel.aParam = "";
        return baseModel;
    }

    /**
     *          根据不同的type 调用不同的支付接口
     * @return
     */
    public BaseModel CreateBaseModelByType(String type) {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = type;
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

    public static class PayBean extends BaseBean{
        /***渠道名称****/
        @SerializedName("n")
        public String channelName;
        /***商品ID****/
        @SerializedName("g")
        public String goodsId;
        /***平台ID****/
        @SerializedName("p")
        public String platformId;

        public PayBean(String channelName, String goodsId, String platformId) {
            this.channelName = channelName;
            this.goodsId = goodsId;
            this.platformId = platformId;
        }
    }

}
