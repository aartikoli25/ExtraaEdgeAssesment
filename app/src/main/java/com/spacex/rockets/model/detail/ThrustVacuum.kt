package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ThrustVacuum {
    @SerializedName("kN")
    @Expose
    var kN = 0

    @SerializedName("lbf")
    @Expose
    var lbf = 0
}