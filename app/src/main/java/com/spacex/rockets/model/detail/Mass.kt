package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Mass {
    @SerializedName("kg")
    @Expose
    var kg = 0

    @SerializedName("lb")
    @Expose
    var lb = 0
}