package com.example.beer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beer.datasource.BeerRepository
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.APIListener

class MainViewModel(private val repository: BeerRepository) : ViewModel() {


    class viewModelFactory(
        private val repository: BeerRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }

    private val _favoritesBeers = MutableLiveData<List<BeerRecipe>>()
    var favoritesBeers: LiveData<List<BeerRecipe>> = _favoritesBeers

    private val _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun listAllRemote() {
        repository.listRemote(object : APIListener<List<BeerRecipe>> {
            override fun onSuccess(model: List<BeerRecipe>) {
                _favoritesBeers.value = model
            }

            override fun onFailure(failure: String) {
                _error.value = failure
            }

        })
    }

    fun saveFavorite(beerRecipe: BeerRecipe) {
//        repository.save(beerRecipe, object : APIListener<Boolean> {
//
//
//        })
    }

    fun loadFavorites() {
//        repository.all(object : APIListener<TaskNetwork> {
//            override fun onSuccess(network: TaskNetwork) {
//                mTask.value = network
//            }
//
//            override fun onFailure(failure: String) {
//                mTask.value = null
//            }
//
//        })
    }

}