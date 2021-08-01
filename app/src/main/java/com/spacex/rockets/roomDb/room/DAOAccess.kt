package com.spacex.rockets.roomDb.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.rockets.roomDb.RocketListRoomModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(rocketListRoomModel: RocketListRoomModel)

    @Query("SELECT * FROM RocketList")
    fun getList(): LiveData<List<RocketListRoomModel>>

    @Query("SELECT COUNT(id) FROM RocketList")
    fun getDataCount(): LiveData<Int>

    @Query("SELECT * FROM RocketList")
    fun deleteList(): LiveData<List<RocketListRoomModel>>

}
