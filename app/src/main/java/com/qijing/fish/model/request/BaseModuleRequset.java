package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/27.
 */

public class BaseModuleRequset extends BaseRequest{
    /**
     *  自增记数
     */
    public static int count;
    /**
     * 模块交换器
     */
    @SerializedName("e")
    public String eModel;
    /**
     * 模块队列名
     */
    @SerializedName("q")
    public String qModel;
    /**
     *   自增序列号
     */
    @SerializedName("n")
    public String nModel;
    /**
     *  请求数据体
     */
    @SerializedName("d")
    public BaseModel dModel;
}
