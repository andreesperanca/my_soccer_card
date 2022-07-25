package com.voltaire.mysoccercard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.voltaire.mysoccercard.R
import com.voltaire.mysoccercard.databinding.ActivityPlayersListBinding
import com.voltaire.mysoccercard.databinding.ActivityShowCardBinding
import com.voltaire.mysoccercard.models.Player
import com.voltaire.mysoccercard.utils.Image

class ShowCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityShowCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadPlayer()

        binding.root.setOnClickListener {
            Image.share(this, binding.root)
        }

    }

    private fun loadPlayer() {
        with(binding) {
            val args = intent.getParcelableExtra<Player>("Player")
            tvName.text = args?.name
            tvPas.text = args?.passing.toString()
            tvDef.text = args?.defending.toString()
            tvChu.text = args?.shooting.toString()
            tvRatting.text = args?.ratting.toString()
            tvFis.text = args?.physical.toString()
            tvDib.text = args?.dribbling.toString()
            tvVel.text = args?.pace.toString()
            tvPosition.text = args?.position.toString()

            Glide
                .with(this@ShowCardActivity)
                .load(args?.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.card)
                .into(binding.ivPhoto);

        }
    }
}