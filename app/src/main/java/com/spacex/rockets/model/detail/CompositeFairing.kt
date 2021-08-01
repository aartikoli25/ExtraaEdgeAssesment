package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CompositeFairing {
    @SerializedName("height")
    @Expose
    var height: Height__1? = null

    @SerializedName("diameter")
    @Expose
    var diameter: Diameter__1? = null
}