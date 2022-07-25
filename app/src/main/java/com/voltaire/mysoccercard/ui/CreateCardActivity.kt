package com.voltaire.mysoccercard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.voltaire.mysoccercard.App
import com.voltaire.mysoccercard.R
import com.voltaire.mysoccercard.databinding.ActivityCreateCardBinding
import com.voltaire.mysoccercard.databinding.ActivityMainBinding
import com.voltaire.mysoccercard.models.Player

class CreateCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCreateCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            createPlayer()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun createPlayer() {
        val newPlayer = Player(
            name = binding.tilName.editText?.text.toString(),
            position = binding.tilPosition.editText?.text.toString(),
            pace = binding.tilSpeedAcceleration.editText?.text.toString().toInt(),
            shooting = binding.tilShot.editText?.text.toString().toInt(),
            passing = binding.tilPassing.editText?.text.toString().toInt(),
            dribbling = binding.tilDribbling.editText?.text.toString().toInt(),
            physical = binding.tilPhysical.editText?.text.toString().toInt(),
            defending = binding.tilDefense.editText?.text.toString().toInt(),
            imageUrl = binding.tilUrlImage.editText?.text.toString()
        )
        mainViewModel.insert(newPlayer)
        Toast.makeText(this, "Sucesso na criação.", Toast.LENGTH_SHORT).show()
        finish()
    }

}