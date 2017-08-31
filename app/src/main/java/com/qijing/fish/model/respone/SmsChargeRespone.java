package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/5.
 */

public class SmsChargeRespone {


//     1. unipin 支付购买商品        d.a   unipin_pay      返回  {"r":"result","p":{"u":"payment_url"}}
//     1. coda SMS 支付购买商品      d.a   coda_sms_pay    返回  {"r":"result","p":{"a":"api_key","e":"api_env","a":"order_id"}}
//     1. coda BANK 支付购买商品     d.a   coda_bank_pay   返回  {"r":"result","p":{"u":"payment_url"}}
//     1. mimopay BANK 支付购买商品  d.a   mimopay_bank    返回  {"r":"result","p":{"u":"payment_url"}}
//     1. minopay SMS 支付购买商品   d.a   mimopay_sms     返回  {"r":"result","p":{"t":"transition id", "c":"merchantCode", "n":"productName", "k":"staging key", "g":"gateway key"}}
    /**
     *   网页支付跳转的url
     */
    @SerializedName("u")
    public String payment_url;

    @SerializedName("a")
    public String codaApiKey;
    @SerializedName("e")
    public String codaApiEnv;
    @SerializedName("o")
    public String codaApiOrderId;

    @SerializedName("t")
    public String mimoPayTransitionId;
    @SerializedName("c")
    public String mimoPayMerchantCode;
    @SerializedName("n")
    public String mimoPayProductName;
    @SerializedName("k")
    public String mimoPayStagingkey;
    @SerializedName("g")
    public String mimoPayGatewaykey;
    @SerializedName("x")
    public String mimoPayIsOnline;

}
