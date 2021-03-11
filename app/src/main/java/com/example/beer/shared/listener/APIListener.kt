package com.example.beer.shared.listener

interface APIListener<T> {
    fun onSuccess(result: T)
    fun onFailure(failure: String)
}