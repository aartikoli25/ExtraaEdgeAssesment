package com.spacex.rockets.model.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SecondStage {
    @SerializedName("thrust")
    @Expose
    var thrust: Thrust? = null

    @SerializedName("payloads")
    @Expose
    var payloads: Payloads? = null

    @SerializedName("reusable")
    @Expose
    var reusable = false

    @SerializedName("engines")
    @Expose
    var engines = 0

    @SerializedName("fuel_amount_tons")
    @Expose
    var fuelAmountTons = 0f

    @SerializedName("burn_time_sec")
    @Expose
    var burnTimeSec: Any? = null
}