package com.qijing.fish.model.respone;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/7/22.
 */

public class LiveGiftRespone implements Parcelable {
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

    /**礼物ID**/
    @SerializedName("a")
    public String giftId;
    /**礼物类型，1：连击礼物；2：全屏礼物；**/
    @SerializedName("b")
    public String giftType;
    /**礼物在礼物列表展示名称**/
    @SerializedName("c")
    public String giftName;
    /**消耗的金币数量**/
    @SerializedName("g")
    public String giftValue;
    /**礼物图片**/
    @SerializedName("k")
    public String giftImage;
    /**是否是积分礼物  0：不是 1：是**/
    @SerializedName("n")
    public String giftIsIntegral;
    /**礼物积分**/
    @SerializedName("i")
    public String giftIntegral;
    /**商城的特殊显示标签 0/没有 1/hot 2/new**/
    @SerializedName("l")
    public String giftLable;
    /**礼物增加的魅力值**/
    @SerializedName("m")
    public String giftCharm;

    public boolean giftSel;

    protected LiveGiftRespone(Parcel in) {
        giftId = in.readString();
        giftType = in.readString();
        giftName = in.readString();
        giftValue = in.readString();
        giftImage = in.readString();
        giftIsIntegral = in.readString();
        giftIntegral = in.readString();
        giftLable = in.readString();
        giftCharm = in.readString();
        giftSel = in.readByte() != 0;
    }

    public static final Creator<LiveGiftRespone> CREATOR = new Creator<LiveGiftRespone>() {
        @Override
        public LiveGiftRespone createFromParcel(Parcel in) {
            return new LiveGiftRespone(in);
        }

        @Override
        public LiveGiftRespone[] newArray(int size) {
            return new LiveGiftRespone[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(giftId);
        dest.writeString(giftType);
        dest.writeString(giftName);
        dest.writeString(giftValue);
        dest.writeString(giftImage);
        dest.writeString(giftIsIntegral);
        dest.writeString(giftIntegral);
        dest.writeString(giftLable);
        dest.writeString(giftCharm);
        dest.writeByte((byte) (giftSel ? 1 : 0));
    }
}
