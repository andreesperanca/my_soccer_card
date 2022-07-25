package com.voltaire.mysoccercard

import android.app.Application
import com.voltaire.mysoccercard.data.local.AppDataBase
import com.voltaire.mysoccercard.repositories.CardsRepository

class App : Application() {
    val database by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { CardsRepository(database.playerCardDao()) }
}