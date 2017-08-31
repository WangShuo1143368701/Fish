package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/28.
 *  获取支付渠道列表和渠道相关支付的金额
 */

public class SmsChannelBody extends BaseBody{
    public  final String CHANNEL_SMS = "channel_sms";
    public  final String CHANNEL_CARD = "channel_card";
    public  String CHANNEL_BANK = "channel_bank";
    /***获取不同渠道的商品列表***/
    public  String COINS_LIST = "coins_list";
    /**
     *                      获取支付           渠道
     *                      第一层数据  固定值  "e":"php.goods.direct"  "q":"php_goods"
     *                      第二层数据  固定值  "k":"token"
                                                "c":"goods"
                                        可变值   a
                            第三层数据  不需要

                             sms支付渠道列表                             a = channel_sms
                             @param {"e":"php.goods.direct", "q":"php_goods","d":{"k":"token","c":"goods","a":"channel_sms"}}
                             @return {"r":"0","p":[{"n":"channel_name","b":"business_name"},{"n":"channel_name","b":"business_name"}]}
                             //////////////////
                             card支付渠道列表                            a = channel_card
                             @param {"e":"php.goods.direct", "q":"php_goods","d":{"k":"token","c":"goods","a":"channel_card"}}
                             @return {"r":"0","p":[{"n":"channel_name","b":"business_name"},{"n":"channel_name","b":"business_name"}]}
                             p.n 支付渠道名称
                             p.b 支付商名称 1=>unipin 2=>coda
                             ///////////////////
                             bank支付渠道列表                            a = channel_bank
                             @param {"e":"php.goods.direct", "q":"php_goods","d":{"k":"token","c":"goods","a":"channel_bank"}}
                             @return {"r":"0","p":[{"n":"channel_name","b":"business_name"},{"n":"channel_name","b":"business_name"}]}
                             p.n 支付渠道名称
                             p.b 支付商名称 1=>unipin 2=>coda
                             /////////////////
                             获取支付渠道相关支付金额                   a = coins_list
     *                                              第三层数据         n =  ChannelName
     **/
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "php.goods.direct";
        baseModuleRequset.qModel = "php_goods";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        return baseModel;
    }

    /**
     *
     * @param channel      channel_sms
     *                       channel_card
     * @return              channel_bank
     *                       coins_list
     */
    public BaseModel CreateBaseModel(String channel) {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "goods";
        baseModel.aParam = channel;
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

    public static class Channel extends BaseBean{
        @SerializedName("n")
        public String ChannelName;

        public Channel(String channelName) {
            ChannelName = channelName;
        }
    }
}
