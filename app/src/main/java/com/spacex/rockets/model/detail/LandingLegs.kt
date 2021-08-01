package com.spacex.rockets.model.detail

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