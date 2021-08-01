package com.spacex.rockets.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.spacex.rockets.R
import com.spacex.rockets.model.detail.RocketDetailResponse
import com.spacex.rockets.networks.ApiHelper
import com.spacex.rockets.networks.RetrofitBuilder
import com.spacex.rockets.utils.Constants
import com.spacex.rockets.view.adapter.SliderAdapter
import com.spacex.rockets.utils.Status
import com.spacex.rockets.viewmodel.MainViewModel
import com.spacex.rockets.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_rocket_detail.*

class RocketDetailActivity : AppCompatActivity() {

    var datalist: ArrayList<String> = arrayListOf()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_detail)

        var id = intent.getStringExtra("ID")

        setupViewModel()
        setupObservers(id.toString())


        iv_back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers(id: String) {
        viewModel.getRocketsDetail(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        layout_main.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { rocketDetail -> retrieveDetail(rocketDetail) }
                        Constants.isNetworkAvailable = true
                    }
                    Status.ERROR -> {
                        layout_main.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        Constants.isNetworkAvailable = false
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        layout_main.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveDetail(rocketDetailResponse: RocketDetailResponse) {

        textview_title.setText(rocketDetailResponse.name)

        if (rocketDetailResponse.active) {
            textview_status.setTextColor(resources.getColor(R.color.green))
            textview_status.setText(getString(R.string.active))
        } else {
            textview_status.setTextColor(resources.getColor(R.color.red))
            textview_status.setText(getString(R.string.inactive))
        }

        datalist = ArrayList<String>()
        for (i in 0 until rocketDetailResponse.flickrImages!!.size) {
            datalist.add(rocketDetailResponse.flickrImages!!.get(i))
        }

        var adapter = SliderAdapter(this, datalist)
        image_slider!!.setSliderAdapter(adapter)
        image_slider!!.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM)
        image_slider!!.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        image_slider!!.isAutoCycle = false


        textview_cost.setText(getString(R.string.cost_per_launch_b) + rocketDetailResponse.costPerLaunch)
        textview_success_rate_per.setText(getString(R.string.success_rate_percent_b) + rocketDetailResponse.successRatePct)
        textview_hight_and_diameter.setText(getString(R.string.height_diameter_in_feet_or_inches_b) + rocketDetailResponse.height!!.feet + " X " + rocketDetailResponse.diameter!!.feet)
        textview_description.setText(rocketDetailResponse.description)
        textview_link.setText(rocketDetailResponse.wikipedia)
    }
}