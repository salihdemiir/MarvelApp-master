package com.mte.marvelapp.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.system.Os
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.mte.marvelapp.data.remote.model.character.Character
import com.mte.marvelapp.data.remote.model.comic.Comic
import com.mte.marvelapp.data.remote.model.event.Events
import com.mte.marvelapp.data.remote.model.series.Series
import com.mte.marvelapp.data.remote.model.stories.Stories
import com.mte.marvelapp.databinding.FragmentHomeBinding
import com.mte.marvelapp.ui.home.adapter.CharacterAdapter
import com.mte.marvelapp.ui.home.adapter.ComicsAdapter
import com.mte.marvelapp.ui.home.adapter.EventsAdapter
import com.mte.marvelapp.ui.home.adapter.SeriesAdapter
import com.mte.marvelapp.ui.home.adapter.StoriesAdapter
import com.mte.marvelapp.ui.home.adapter.listener.CharacterClickListener
import com.mte.marvelapp.ui.home.adapter.listener.ComicClickListener
import com.mte.marvelapp.ui.home.adapter.listener.EventsClickListener
import com.mte.marvelapp.ui.home.adapter.listener.SeriesClickListener
import com.mte.marvelapp.ui.home.adapter.listener.StoriesClickListener
import com.mte.marvelapp.ui.home.uistate.CharacterUiState
import com.mte.marvelapp.ui.home.uistate.ComicsUiState
import com.mte.marvelapp.ui.home.uistate.EventsUiState
import com.mte.marvelapp.ui.home.uistate.SeriesUiState
import com.mte.marvelapp.ui.home.uistate.StoriesUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow



@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeViewModel by viewModels()

    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var seriesAdapter: SeriesAdapter
    private lateinit var comicsAdapter: ComicsAdapter
    private lateinit var storiesAdapter: StoriesAdapter
    private lateinit var eventsAdapter : EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
        sendApiRequests()
        observeEvents()
    }

    private fun observeEvents() = with(binding){

        viewModel.characterUiState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is CharacterUiState.Loading -> {
                    pbHeroes.visibility = View.VISIBLE
                    rvHeroes.visibility = View.GONE
                }
                is CharacterUiState.Success -> {
                    state.data?.let {
                        pbHeroes.visibility = View.GONE
                        characterAdapter.characters = state.data
                        rvHeroes.visibility = View.VISIBLE
                    }
                }
                is CharacterUiState.Error -> {

                }
            }
        })

        viewModel.seriesUiState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is SeriesUiState.Loading -> {
                    pbSeries.visibility = View.VISIBLE
                    rvSeries.visibility = View.GONE
                }
                is SeriesUiState.Success -> {
                    state.data?.let {
                        pbSeries.visibility = View.GONE
                        seriesAdapter.series = state.data
                        rvSeries.visibility = View.VISIBLE
                    }
                }
                is SeriesUiState.Error -> {

                }
            }
        })

        viewModel.comicsUiState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is ComicsUiState.Loading -> {
                    pbComics.visibility = View.VISIBLE
                    rvComics.visibility = View.GONE
                }
                is ComicsUiState.Success -> {
                    state.data?.let {
                        pbComics.visibility = View.GONE
                        comicsAdapter.comics = state.data
                        rvComics.visibility = View.VISIBLE
                    }
                }
                is ComicsUiState.Error -> {

                }
            }
        })

        viewModel.storiesUiState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is StoriesUiState.Loading -> {
                    pbStories.visibility = View.VISIBLE
                    rvStories.visibility = View.GONE
                }
                is StoriesUiState.Success -> {
                    state.data?.let {
                        pbStories.visibility = View.GONE
                        storiesAdapter.stories = state.data
                        rvStories.visibility = View.VISIBLE
                    }
                }
                is StoriesUiState.Error -> {

                }
            }
        })

        viewModel.eventsUiState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is EventsUiState.Loading -> {
                    pbEvents.visibility = View.VISIBLE
                    rvEvents.visibility = View.GONE
                }
                is EventsUiState.Success -> {
                    state.data?.let {
                        pbEvents.visibility = View.GONE
                        eventsAdapter.events = state.data
                        rvEvents.visibility = View.VISIBLE
                    }
                }
                is EventsUiState.Error -> {

                }
            }
        })
    }

    private fun setupRecyclerViews() = with(binding){
        characterAdapter = CharacterAdapter(object : CharacterClickListener{
            override fun onCharacterClick(character: Character) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }
        })

        seriesAdapter = SeriesAdapter(object : SeriesClickListener{
            override fun onSeriesClick(series: Series) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }
        })

        comicsAdapter = ComicsAdapter(object : ComicClickListener{
            override fun onComicClick(comic: Comic) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }

        })

        storiesAdapter = StoriesAdapter(object : StoriesClickListener{
            override fun onStoriesClick(stories: Stories) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }

        })

        eventsAdapter = EventsAdapter(object : EventsClickListener{
            override fun onEventsClick(events: Events) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }

        })

        rvHeroes.adapter = characterAdapter
        rvSeries.adapter = seriesAdapter
        rvComics.adapter = comicsAdapter
        rvStories.adapter = storiesAdapter
        rvEvents.adapter = eventsAdapter
    }

    private fun sendApiRequests() = with(viewModel){
        fetchCharacters()
        fetchSeries()
        fetchComics()
        fetchStories()
        fetchEvents()
    }


    override fun onPause() {
        super.onPause()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}