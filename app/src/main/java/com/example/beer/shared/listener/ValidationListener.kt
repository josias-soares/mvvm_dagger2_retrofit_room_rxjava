package com.example.beer.shared.listener

class ValidationListener(message: String = "") {
    private var success: Boolean = true
    private var message: String = ""

    init {
        if (message.isNotEmpty()){
            success = false
            this.message = message
        }
    }

    fun success() = success
    fun failure() = message
}