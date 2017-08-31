package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/27.
 */

public class BaseModel {
    /**用户toket**/
    @SerializedName("k")
    public String kParam;
    /** user**/
    @SerializedName("c")
    public String cParam;
    /**模块接口名**/
    @SerializedName("a")
    public String aParam;
    /**房间banner 版本号**/
    @SerializedName("v")
    public String version;
    @SerializedName("p")
    public BaseBean baseBean;
    @SerializedName("l")
    public ArrayList<BaseBean> baseBeans;
}
