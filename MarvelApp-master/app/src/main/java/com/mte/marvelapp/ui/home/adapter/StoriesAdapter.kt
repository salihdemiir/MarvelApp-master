package com.mte.marvelapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mte.marvelapp.data.remote.model.stories.Stories
import com.mte.marvelapp.databinding.RecyclerStoriesLayoutBinding
import com.mte.marvelapp.ui.home.adapter.listener.StoriesClickListener

class StoriesAdapter (private val storiesClickListener: StoriesClickListener) : RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Stories>(){
        override fun areItemsTheSame(oldItem: Stories, newItem: Stories): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stories, newItem: Stories): Boolean {
            return oldItem == newItem
        }

    }

    private val diffList = AsyncListDiffer(this,diffUtil)
    var stories : List<Stories>
        get() = diffList.currentList
        set(value) = diffList.submitList(value)


    class StoriesViewHolder (private val binding : RecyclerStoriesLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (stories: Stories,storiesClickListener: StoriesClickListener){
            binding.stories = stories
            binding.clickListener = storiesClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val binding = RecyclerStoriesLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        holder.bind(stories[position],storiesClickListener)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

}