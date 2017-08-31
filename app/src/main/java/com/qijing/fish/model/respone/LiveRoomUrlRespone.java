package com.qijing.fish.model.respone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by czl on 2017/6/30.
 *   {"r":"result","p":{"u":"pull_url"}}
 */

public class LiveRoomUrlRespone {
    @SerializedName("u")
    public String pull_url;
}
