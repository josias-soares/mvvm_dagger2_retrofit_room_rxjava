package com.example.beer.shared.listener

interface BeerListener {

    fun onListClick(id: Int)

    fun onDeleteClick(id: Int)

    fun onCompleteClick(id: Int)

    fun onUndoClick(id: Int)

}