package com.qijing.fish.model.request;


import com.qijing.fish.Config;

/**
 * Created by czl on 2017/6/28.
 */

public abstract class BaseBody {


    public static String BASE_UEL = Config.HTTP_post_URL + Config.HTTP_POST_PARAM;

    public abstract BaseModuleRequset CreateBaseRequest();
    public abstract BaseModel CreateBaseModel();
    public abstract BaseBean CreateBaseBean(BaseBean baseBean);
    public String getUrl(){
        return BASE_UEL + getToket();
    }

    public String getToket() {
        return "a010972c5aedf5defb8dd62e6004b0eb747ed25c22ea9599c80725da1284c940fc0a1fd09b7423d98a9ed554d26e31db1bf9919987da26b46d76c547e7df5711";
    }
}
