package com.spacex.rockets.roomDb.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.spacex.rockets.roomDb.RocketListRoomModel
import com.spacex.rockets.roomDb.room.RocketListDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RocketListRoomRepository {

    companion object {

        var rocketListDatabase: RocketListDatabase? = null

        var rocketListRoomModel: LiveData<List<RocketListRoomModel>>? = null

        fun initializeDB(context: Context): RocketListDatabase {
            return RocketListDatabase.getDataseClient(context)
        }

        fun insertData(
            context: Context, name: String, country: String,
            engine_count: String, image: String, id: String
        ) {

            rocketListDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val rocketList = RocketListRoomModel(name, country, engine_count, image, id)
                rocketListDatabase!!.rocketListDao().InsertData(rocketList)
            }

        }

        fun getList(context: Context): LiveData<List<RocketListRoomModel>>? {

            rocketListDatabase = initializeDB(context)

            rocketListRoomModel = rocketListDatabase!!.rocketListDao().getList()

            return rocketListRoomModel
        }

        fun getDataCount(context: Context): LiveData<Int> {

            rocketListDatabase = initializeDB(context)

            var size = rocketListDatabase!!.rocketListDao().getDataCount()

            return size
        }

        fun deleteList(context: Context): LiveData<List<RocketListRoomModel>> {
            rocketListDatabase = initializeDB(context)
            return rocketListDatabase!!.rocketListDao().deleteList()
        }

    }
}