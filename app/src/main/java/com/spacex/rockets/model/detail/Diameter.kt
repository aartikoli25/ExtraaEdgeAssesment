package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Diameter {
    @SerializedName("meters")
    @Expose
    var meters = 0f

    @SerializedName("feet")
    @Expose
    var feet = 0f
}