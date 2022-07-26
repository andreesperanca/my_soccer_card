package com.voltaire.mysoccercard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.voltaire.mysoccercard.models.Player
import com.voltaire.mysoccercard.repositories.CardsRepository

class MainViewModel(private val repository: CardsRepository): ViewModel() {

    fun insert(player: Player) {
        repository.insertPlayer(player)
    }
    fun getAll(): LiveData<List<Player>> = repository.getAll()
}

class MainViewModelFactory (private val repository: CardsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}