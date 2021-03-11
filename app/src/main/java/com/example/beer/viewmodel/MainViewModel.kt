package com.example.beer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beer.datasource.BeerRepository
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.APIListener
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: BeerRepository
) : ViewModel() {

    class viewModelFactory(
        private val repository: BeerRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }

    private val _favoritesBeers = MutableLiveData<List<BeerRecipe>>()
    var favoritesBeers: LiveData<List<BeerRecipe>> = _favoritesBeers

    private val _remoteBeers = MutableLiveData<List<BeerRecipe>>()
    var remoteBeers: LiveData<List<BeerRecipe>> = _remoteBeers

    private val _beerDeleted = MutableLiveData<Boolean>()
    var beerDeleted: LiveData<Boolean> = _beerDeleted

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun getRemoteBeers() {
        repository.listRemote(object : APIListener<List<BeerRecipe>> {
            override fun onSuccess(result: List<BeerRecipe>) {
                _remoteBeers.value = result
            }

            override fun onFailure(failure: String) {
                _error.value = failure
            }

        })
    }

    fun getFavoritesBeers() {
        repository.favorites(object : APIListener<List<BeerRecipe>> {
            override fun onSuccess(result: List<BeerRecipe>) {
                _favoritesBeers.value = result
            }

            override fun onFailure(failure: String) {
                _error.value = failure
            }

        })
    }

    fun deleteFavorite(id: Int) {
        repository.delete(id, object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean) {
                _beerDeleted.value = result
            }

            override fun onFailure(failure: String) {
                _error.value = failure
            }
        })
    }

    fun addFavorite(beerRecipe: BeerRecipe) {
        repository.save(beerRecipe, object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean) {
                //_beerDeleted.value = result
            }

            override fun onFailure(failure: String) {
                //_error.value = failure
            }
        })
    }
}