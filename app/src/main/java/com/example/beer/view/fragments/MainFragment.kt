package com.example.beer.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.beer.R
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.BeerListener
import com.example.beer.view.adapter.BeerAdapter
import com.example.beer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.view.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment), BeerListener {

    private val _listRemoteBeers: MutableList<BeerRecipe> = mutableListOf()
    private val _listFavoriteBeers: MutableList<BeerRecipe> = mutableListOf()
    private lateinit var _adapter: BeerAdapter

    @Inject
    lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        //(requireActivity().applicationContext as BaseApplication).appComponent.inject(this)
//
//        // viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//
//        setComponents()
//        setListeners()
//
//        getData()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setComponents()
        setListeners()

        getData()
    }

    private fun getData() {
        viewModel.getRemoteBeers()
        viewModel.getFavoritesBeers()
    }

    private fun setListeners() {
        viewModel.favoritesBeers.observe(requireActivity(), { favorites ->
            _listFavoriteBeers.clear()
            _listFavoriteBeers.addAll(favorites)

            _adapter.notifyDataSetChanged()
        })

        viewModel.remoteBeers.observe(requireActivity(), { remotes ->
            _listRemoteBeers.clear()
            _listRemoteBeers.addAll(remotes)
            _adapter.notifyDataSetChanged()
        })
    }

    private fun setComponents() {
        requireView().rv_beers_favorites.layoutManager = GridLayoutManager(requireContext(), 2)
        _adapter = BeerAdapter(_listFavoriteBeers, _listRemoteBeers, this)
        requireView().rv_beers_favorites.adapter = _adapter
        _adapter.notifyDataSetChanged()

    }

    override fun onDetails(id: Int?) {
        Toast.makeText(requireContext(), "onDetails", Toast.LENGTH_LONG).show()
    }

    override fun onFavorite(beerRecipe: BeerRecipe?) {
        if (beerRecipe != null) viewModel.addFavorite(beerRecipe)
        Toast.makeText(requireContext(), "onFavorite", Toast.LENGTH_LONG).show()
    }

    override fun onDeleteFavorite(id: Int?) {
        if (id != null) viewModel.deleteFavorite(id)
        Toast.makeText(requireContext(), "onDeleteFavorite", Toast.LENGTH_LONG).show()
    }
}