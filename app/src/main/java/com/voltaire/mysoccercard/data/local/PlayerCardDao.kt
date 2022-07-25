package com.voltaire.mysoccercard.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.voltaire.mysoccercard.models.Player


@Dao
interface PlayerCardDao {

    @Query("SELECT * FROM Player")
    fun getAll (): LiveData<List<Player>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(playerCard: Player)

}