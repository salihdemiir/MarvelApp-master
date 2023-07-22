package com.mte.marvelapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mte.marvelapp.data.remote.model.event.Events
import com.mte.marvelapp.databinding.RecyclerEventsLayoutBinding
import com.mte.marvelapp.ui.home.adapter.listener.EventsClickListener


class EventsAdapter (private val eventsClickListener : EventsClickListener) : RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Events>(){
        override fun areItemsTheSame(oldItem: Events, newItem: Events): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Events, newItem: Events): Boolean {
            return oldItem == newItem
        }

    }

    private val diffList = AsyncListDiffer(this,diffUtil)
    var events : List<Events>
        get() = diffList.currentList
        set(value) = diffList.submitList(value)

    class EventsViewHolder (private val binding : RecyclerEventsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (events: Events, eventsClickListener: EventsClickListener){
            binding.events = events
            binding.clickListener = eventsClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val binding = RecyclerEventsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventsAdapter.EventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(events[position],eventsClickListener)
    }
    override fun getItemCount(): Int {
        return events.size
    }
}