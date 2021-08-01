package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Engines {
    @SerializedName("isp")
    @Expose
    var isp: Isp? = null

    @SerializedName("thrust_sea_level")
    @Expose
    var thrustSeaLevel: ThrustSeaLevel__1? = null

    @SerializedName("thrust_vacuum")
    @Expose
    var thrustVacuum: ThrustVacuum__1? = null

    @SerializedName("number")
    @Expose
    var number = 0

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("version")
    @Expose
    var version: String? = null

    @SerializedName("layout")
    @Expose
    var layout: String? = null

    @SerializedName("engine_loss_max")
    @Expose
    var engineLossMax = 0

    @SerializedName("propellant_1")
    @Expose
    var propellant1: String? = null

    @SerializedName("propellant_2")
    @Expose
    var propellant2: String? = null

    @SerializedName("thrust_to_weight")
    @Expose
    var thrustToWeight = 0f
}