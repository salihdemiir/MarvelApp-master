package com.mte.marvelapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mte.marvelapp.data.remote.model.comic.Comic
import com.mte.marvelapp.databinding.RecyclerComicsLayoutBinding
import com.mte.marvelapp.ui.home.adapter.listener.ComicClickListener

class ComicsAdapter (private val comicClickListener: ComicClickListener) : RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Comic>(){
        override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
            return oldItem == newItem
        }

    }

    private val diffList = AsyncListDiffer(this,diffUtil)
    var comics : List<Comic>
        get() = diffList.currentList
        set(value) = diffList.submitList(value)

    class ComicsViewHolder(private val binding : RecyclerComicsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comic: Comic,comicClickListener: ComicClickListener){
            binding.comic = comic
            binding.clickListener = comicClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val binding = RecyclerComicsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ComicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(comics[position],comicClickListener)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

}