package com.voltaire.mysoccercard.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.voltaire.mysoccercard.App
import com.voltaire.mysoccercard.R
import com.voltaire.mysoccercard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnCreate.setOnClickListener {
            val intent = Intent(this, CreateCardActivity::class.java)
            startActivity(intent)
        }

        binding.btnView.setOnClickListener {
            val intent = Intent(this, PlayersList::class.java)
            startActivity(intent)
        }
    }

    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }
}