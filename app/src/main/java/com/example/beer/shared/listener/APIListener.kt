package com.example.beer.shared.listener

interface APIListener<T> {
    fun onSuccess(model: T)
    fun onFailure(failure: String)
}