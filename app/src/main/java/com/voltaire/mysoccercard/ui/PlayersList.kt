package com.voltaire.mysoccercard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.voltaire.mysoccercard.App
import com.voltaire.mysoccercard.R
import com.voltaire.mysoccercard.databinding.ActivityMainBinding
import com.voltaire.mysoccercard.databinding.ActivityPlayersListBinding
import com.voltaire.mysoccercard.models.Player

class PlayersList : AppCompatActivity() {

    private val binding by lazy { ActivityPlayersListBinding.inflate(layoutInflater) }
    private lateinit var adapter: PlayerAdapter

    private val viewModels: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureRecyclerView()

        viewModels.getAll().observe(this) {
            adapter.updateList(it)
        }
    }

    private fun configureRecyclerView() {
        adapter = PlayerAdapter(emptyList())
        val divisor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.rvPlayers.addItemDecoration(divisor)
        binding.rvPlayers.adapter = adapter
        binding.rvPlayers.layoutManager = LinearLayoutManager(this, VERTICAL, false)
    }
}