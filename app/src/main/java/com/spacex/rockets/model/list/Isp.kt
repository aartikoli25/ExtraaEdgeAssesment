package com.spacex.rockets.model.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Isp {
    @SerializedName("sea_level")
    @Expose
    var seaLevel = 0

    @SerializedName("vacuum")
    @Expose
    var vacuum = 0
}