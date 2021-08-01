package com.spacex.rockets.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacex.rockets.R
import com.spacex.rockets.model.list.RocketListResponse
import com.spacex.rockets.networks.ApiHelper
import com.spacex.rockets.networks.RetrofitBuilder
import com.spacex.rockets.view.adapter.MainAdapter
import com.spacex.rockets.utils.Status
import com.spacex.rockets.viewmodel.MainViewModel
import com.spacex.rockets.viewmodel.ViewModelFactory
import androidx.lifecycle.ViewModelProviders
import com.spacex.rockets.roomDb.RocketListRoomAdapter
import com.spacex.rockets.utils.Constants
import com.spacex.rockets.roomDb.viewmodel.RocketListRoomViewModel
import kotlinx.android.synthetic.main.activity_rockets_list.*

class RocketsListActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var roomAdapter: RocketListRoomAdapter

    lateinit var rocketListRoomViewModel: RocketListRoomViewModel
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets_list)

        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)

        context = this@RocketsListActivity
        rocketListRoomViewModel = ViewModelProvider(this).get(RocketListRoomViewModel::class.java)
    }

    private fun setupUI() {
        rv_rockets.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        rv_rockets.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getRocketsList().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        rv_rockets.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { rocketList ->
                            retrieveList(rocketList)
                        }

                        Constants.isNetworkAvailable = true

                    }
                    Status.ERROR -> {
                        rv_rockets.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE

                        //Show offline data
                        rv_rockets.layoutManager = LinearLayoutManager(this)
                        roomAdapter = RocketListRoomAdapter(arrayListOf())
                        rv_rockets.adapter = roomAdapter
                        rocketListRoomViewModel.getList(context)!!.observe(this, Observer {

                            if (it.isEmpty()) {
                                Toast.makeText(context, "Data Not Found", Toast.LENGTH_SHORT).show()
                            } else {
                                roomAdapter.apply {
                                    addRockets(it)
                                    notifyDataSetChanged()
                                    Constants.isNetworkAvailable = false
                                }
                            }
                        })
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        rv_rockets.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(rocketListResponse: List<RocketListResponse>) {

        // Clear previous data and add data in room db

        rocketListRoomViewModel.deleteList(context).observe(this, Observer {

            rocketListRoomViewModel.getDataCount(context).observe(this, Observer {

                if (it == 0) {
                    for (i in 0 until rocketListResponse.size) {
                        rocketListRoomViewModel.insertData(
                            context,
                            rocketListResponse.get(i).name.toString(),
                            rocketListResponse.get(i).country.toString(),
                            rocketListResponse.get(i).firstStage!!.engines.toString(),
                            rocketListResponse.get(i).flickrImages?.get(0).toString(),
                            rocketListResponse.get(i).id.toString()
                        )
                    }
                }
            })
        })

        adapter.apply {
            addRockets(rocketListResponse)
            notifyDataSetChanged()
        }

    }
}