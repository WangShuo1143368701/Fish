package com.qijing.fish.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czl on 2017/6/28.
 * 获取ranging 排行榜数据
 */

public class GameFishBody extends BaseBody {


    public BaseModuleRequset CreateFishBaseRequest(String roomId) {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "broom.direct";
        baseModuleRequset.qModel = roomId;
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    @Override
    public BaseModuleRequset CreateBaseRequest() {
        return null;
    }

    /**
     * 魅力排行天榜
     *
     * @return
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "catch_fish";
        return baseModel;
    }


    /**
     * 请求的实体类
     *
     * @param baseBean
     * @return
     */
    @Override
    public BaseBean CreateBaseBean(BaseBean baseBean) {
        return baseBean;
    }

    private FishBean fishBean = null;

    public FishBean getFishBean() {
        if (fishBean == null) {
            fishBean = new FishBean();


        }
        return fishBean;

    }

    private Fish fish = null;

    public Fish getFish() {
        if (fish == null) {
            fish = new Fish();


        }
        return fish;

    }

    public class FishBean extends BaseBean {
        @SerializedName("c")
        public String value;
        @SerializedName("f")
        public List<Fish> target_fish=new ArrayList<Fish>();
    }

    public class Fish {
        @SerializedName("t")
        public int fishtype;
        @SerializedName("i")
        public int id;
        @SerializedName("n")
        public String name;
    }
}
