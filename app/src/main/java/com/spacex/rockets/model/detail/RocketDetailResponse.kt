package com.spacex.rockets.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RocketDetailResponse {
    @SerializedName("height")
    @Expose
    var height: Height? = null

    @SerializedName("diameter")
    @Expose
    var diameter: Diameter? = null

    @SerializedName("mass")
    @Expose
    var mass: Mass? = null

    @SerializedName("first_stage")
    @Expose
    var firstStage: FirstStage? = null

    @SerializedName("second_stage")
    @Expose
    var secondStage: SecondStage? = null

    @SerializedName("engines")
    @Expose
    var engines: Engines? = null

    @SerializedName("landing_legs")
    @Expose
    var landingLegs: LandingLegs? = null

    @SerializedName("payload_weights")
    @Expose
    var payloadWeights: List<PayloadWeight>? = null

    @SerializedName("flickr_images")
    @Expose
    var flickrImages: List<String>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("active")
    @Expose
    var active = false

    @SerializedName("stages")
    @Expose
    var stages = 0

    @SerializedName("boosters")
    @Expose
    var boosters = 0

    @SerializedName("cost_per_launch")
    @Expose
    var costPerLaunch = 0

    @SerializedName("success_rate_pct")
    @Expose
    var successRatePct = 0

    @SerializedName("first_flight")
    @Expose
    var firstFlight: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("company")
    @Expose
    var company: String? = null

    @SerializedName("wikipedia")
    @Expose
    var wikipedia: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null
}