package com.mte.marvelapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mte.marvelapp.ui.home.adapter.listener.CharacterClickListener
import com.mte.marvelapp.data.remote.model.character.Character
import com.mte.marvelapp.databinding.RecyclerHeroesLayoutBinding

class CharacterAdapter (private val characterClickListener: CharacterClickListener) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }

    private val diffList = AsyncListDiffer(this, diffUtil)
    var characters: List<Character>
        get() = diffList.currentList
        set(value) = diffList.submitList(value)

    class CharacterViewHolder (private val binding : RecyclerHeroesLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character,characterClickListener: CharacterClickListener){
            binding.heroes = character
            binding.clickListener = characterClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = RecyclerHeroesLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position],characterClickListener)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}