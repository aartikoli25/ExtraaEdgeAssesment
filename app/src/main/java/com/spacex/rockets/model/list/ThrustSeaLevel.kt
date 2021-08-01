package com.spacex.rockets.model.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ThrustSeaLevel {
    @SerializedName("kN")
    @Expose
    var kN = 0

    @SerializedName("lbf")
    @Expose
    var lbf = 0
}