package com.mte.marvelapp.ui.home.adapter.listener

import com.mte.marvelapp.data.remote.model.event.Events

interface EventsClickListener {
    fun onEventsClick(events : Events)
}