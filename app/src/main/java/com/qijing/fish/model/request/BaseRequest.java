package com.qijing.fish.model.request;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/6/26.
 * 请求的基类
 */

public class BaseRequest {
    public String toJson(){
        return new Gson().toJson(this);
    }
}

