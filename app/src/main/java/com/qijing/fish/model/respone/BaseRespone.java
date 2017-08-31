package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/26.
 */

public class BaseRespone<T>{
    /**
     * 请求返回的参数 r = 0 正常
     */
    @SerializedName("r")
    public String ret;
    @SerializedName("p")
    public T data;
    @SerializedName("list")
    public ArrayList<T> datas;

    public boolean isOk(){
        if("0".equals(ret)) {
            return true;
        }
        return false;
    }
}
