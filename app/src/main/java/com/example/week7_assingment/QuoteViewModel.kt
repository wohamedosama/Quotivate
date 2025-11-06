package com.example.week7_assingment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Manages the state and business logic for quotes
 */
class QuoteViewModel : ViewModel() {

    private val quoteRepository = QuoteRepository()

    var currentQuote by mutableStateOf("")
        private set

    var isShakeDetected by mutableStateOf(false)
        private set

    var isShakeEnabled by mutableStateOf(true)
        private set

    val totalQuotes: Int = quoteRepository.getQuoteCount()

    init {
        loadRandomQuote()
    }

    fun onShakeDetected() {
        if (!isShakeEnabled) return
        loadRandomQuote()
        isShakeDetected = true
    }

    fun onShakeAnimationComplete() {
        isShakeDetected = false
    }

    fun toggleShakeDetection() {
        isShakeEnabled = !isShakeEnabled
    }

    fun loadNewQuote() {
        loadRandomQuote()
    }

    private fun loadRandomQuote() {
        currentQuote = quoteRepository.getRandomQuote()
    }
}