package com.mte.marvelapp.ui.home.adapter.listener

import com.mte.marvelapp.data.remote.model.series.Series

interface SeriesClickListener {
    fun onSeriesClick(series : Series)
}