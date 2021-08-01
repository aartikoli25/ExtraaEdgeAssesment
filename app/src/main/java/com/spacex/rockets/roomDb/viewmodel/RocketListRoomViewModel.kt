package com.spacex.rockets.roomDb.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacex.rockets.roomDb.RocketListRoomModel
import com.spacex.rockets.roomDb.repository.RocketListRoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketListRoomViewModel @Inject constructor() : ViewModel() {

    var rocketListRoomModel: LiveData<List<RocketListRoomModel>>? = null

    fun insertData(context: Context, name: String, country: String,
                   engine_count: String, image: String, id: String) {
       RocketListRoomRepository.insertData(context, name, country, engine_count, image,id)
    }

    fun getList(context: Context) : LiveData<List<RocketListRoomModel>>? {
        rocketListRoomModel = RocketListRoomRepository.getList(context)
        return rocketListRoomModel

    }

    fun getDataCount(context: Context) : LiveData<Int> {
        var size = RocketListRoomRepository.getDataCount(context)
        return size

    }

    fun deleteList(context: Context) : LiveData<List<RocketListRoomModel>>{
       return RocketListRoomRepository.deleteList(context)
    }


}