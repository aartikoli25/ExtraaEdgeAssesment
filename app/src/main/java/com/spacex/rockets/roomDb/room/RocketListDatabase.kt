package com.spacex.rockets.roomDb.room

import android.content.Context
import androidx.room.*
import com.spacex.rockets.roomDb.RocketListRoomModel

@Database(entities = arrayOf(RocketListRoomModel::class), version = 1, exportSchema = false)
abstract class RocketListDatabase : RoomDatabase() {

    abstract fun rocketListDao(): DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: RocketListDatabase? = null

        fun getDataseClient(context: Context): RocketListDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(
                        context,
                        RocketListDatabase::class.java,
                        "ROCKET_LIST_DATABASE"
                    )
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}