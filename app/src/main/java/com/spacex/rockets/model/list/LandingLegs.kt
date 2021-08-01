package com.spacex.rockets.model.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LandingLegs {
    @SerializedName("number")
    @Expose
    var number = 0

    @SerializedName("material")
    @Expose
    var material: String? = null
}