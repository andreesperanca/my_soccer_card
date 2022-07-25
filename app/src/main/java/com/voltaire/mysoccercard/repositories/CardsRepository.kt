package com.voltaire.mysoccercard.repositories

import com.voltaire.mysoccercard.data.local.PlayerCardDao
import com.voltaire.mysoccercard.models.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardsRepository(private val dao: PlayerCardDao) {

    fun insertPlayer(player: Player) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(player)
        }
    }

    fun getAll() = dao.getAll()

}