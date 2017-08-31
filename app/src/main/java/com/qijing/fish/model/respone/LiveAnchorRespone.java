package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;



public class LiveAnchorRespone {
    @SerializedName("p")
    public String pullUrl;
    @SerializedName("u")
    public String pushUrl;
}
