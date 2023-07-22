package com.mte.marvelapp.ui.home

import android.media.metrics.Event
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mte.marvelapp.data.remote.service.NetworkResult
import com.mte.marvelapp.ui.home.uistate.CharacterUiState
import com.mte.marvelapp.ui.home.uistate.ComicsUiState
import com.mte.marvelapp.ui.home.uistate.EventsUiState
import com.mte.marvelapp.ui.home.uistate.SeriesUiState
import com.mte.marvelapp.ui.home.uistate.StoriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository : HomeRepository) : ViewModel() {

    private val _characterUiState = MutableLiveData<CharacterUiState>()
    val characterUiState: LiveData<CharacterUiState> = _characterUiState

    private val _seriesUiState = MutableLiveData<SeriesUiState>()
    val seriesUiState: LiveData<SeriesUiState> = _seriesUiState

    private val _comicsUiState = MutableLiveData<ComicsUiState>()
    val comicsUiState: LiveData<ComicsUiState> = _comicsUiState

    private val _storiesUiState = MutableLiveData<StoriesUiState>()
    val storiesUiState: LiveData<StoriesUiState> = _storiesUiState

    private val _eventsUiState = MutableLiveData<EventsUiState>()
    val eventsUiState: LiveData<EventsUiState> = _eventsUiState

    fun fetchCharacters() = viewModelScope.launch {
        _characterUiState.value = CharacterUiState.Loading

        val request = repository.fetchCharacters()
        when(request){
            is NetworkResult.Success -> {
                _characterUiState.value = CharacterUiState.Success(request.data?.data?.characters)
            }
            is NetworkResult.Error -> {
                _characterUiState.value = CharacterUiState.Error(request.message)
            }
        }
    }

    fun fetchSeries() = viewModelScope.launch {
        _seriesUiState.value = SeriesUiState.Loading

        val request = repository.fetchSeries()
        when(request){
            is NetworkResult.Success -> {
                _seriesUiState.value = SeriesUiState.Success(request.data?.data?.series)
            }
            is NetworkResult.Error -> {
                _seriesUiState.value = SeriesUiState.Error(request.message)
            }
        }
    }

    fun fetchComics() = viewModelScope.launch {
        _comicsUiState.value = ComicsUiState.Loading

        val request = repository.fetchComics()
        when(request){
            is NetworkResult.Success -> {
                _comicsUiState.value = ComicsUiState.Success(request.data?.data?.comics)
            }
            is NetworkResult.Error -> {
                _comicsUiState.value = ComicsUiState.Error(request.message)
            }
        }
    }

    fun fetchStories() = viewModelScope.launch {
        _storiesUiState.value = StoriesUiState.Loading

        val request = repository.fetchStories()
        when(request){
            is NetworkResult.Success -> {
                _storiesUiState.value = StoriesUiState.Success(request.data?.data?.stories)
            }
            is NetworkResult.Error -> {
                _storiesUiState.value = StoriesUiState.Error(request.message)
            }
        }
    }

    fun fetchEvents() = viewModelScope.launch {
        _eventsUiState.value = EventsUiState.Loading

        val request = repository.fetchEvents()
        when(request){
            is NetworkResult.Success -> {
                _eventsUiState.value = EventsUiState.Success(request.data?.data?.events)
            }
            is NetworkResult.Error -> {
                _eventsUiState.value = EventsUiState.Error(request.message)
            }
        }
    }

}