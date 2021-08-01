package com.spacex.rockets.model.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Height {
    @SerializedName("meters")
    @Expose
    var meters = 0f

    @SerializedName("feet")
    @Expose
    var feet = 0f
}