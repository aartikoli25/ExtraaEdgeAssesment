package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Payloads {
    @SerializedName("composite_fairing")
    @Expose
    var compositeFairing: CompositeFairing? = null

    @SerializedName("option_1")
    @Expose
    var option1: String? = null
}