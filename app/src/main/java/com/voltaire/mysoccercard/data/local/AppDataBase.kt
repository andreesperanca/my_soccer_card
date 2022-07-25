package com.voltaire.mysoccercard.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.voltaire.mysoccercard.models.Player


@Database(entities = [Player::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun playerCardDao(): PlayerCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "playerscard.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}