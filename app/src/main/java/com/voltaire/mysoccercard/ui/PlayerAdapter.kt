package com.voltaire.mysoccercard.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.mysoccercard.databinding.ActivityShowCardBinding
import com.voltaire.mysoccercard.databinding.PlayerItemBinding
import com.voltaire.mysoccercard.models.Player

class PlayerAdapter(private var playerList: List<Player>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PlayerItemBinding.inflate(inflater, parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

    override fun getItemCount(): Int = playerList.size
    fun updateList(it: List<Player>) {
        playerList = it
        notifyDataSetChanged()
    }

    inner class PlayerViewHolder(private val binding: PlayerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Player) {
            binding.playerName.text = item.name

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ShowCardActivity::class.java)
                intent.putExtra("Player", playerList[adapterPosition])
                binding.root.context.startActivity(intent)
            }
        }
    }
}