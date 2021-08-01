package com.spacex.rockets.roomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "RocketList")
data class RocketListRoomModel(

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "engine_count")
    var engine_count: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "id")
    var id: String

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "auto_id")
    var auto_id: Int? = null

}
