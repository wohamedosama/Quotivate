package com.example.week7_assingment

import kotlin.random.Random

class QuoteRepository {

    private val quotes = listOf(
        "Focus on progress, not perfection 🎯",
        "You can do hard things 💪",
        "Shake your phone to get motivated! 💡",
        "Small steps lead to big changes 🚀",
        "Believe in yourself 🌟",
        "Every day is a new opportunity ✨",
        "Your potential is endless 🌈",
        "Stay positive, work hard, make it happen 💯",
        "Don't stop until you're proud 🏆",
        "You are stronger than you think 💪",
        "Dream big, work hard, stay focused 🎯",
        "Progress, not perfection 📈",
        "You've got this! 🔥",
        "Make today amazing 🌞",
        "Be the energy you want to attract ⚡",
        "Success is the sum of small efforts 💎",
        "Keep going, you're doing great! 🌟",
        "The best time to start was yesterday ⏰",
        "You are capable of amazing things 🦋",
        "Embrace the journey 🛤️"
    )

    // if I understood this method to create random map tp call every quote randomly also it's Random.nextInt(quotes.size) to get the list's size
    fun getRandomQuote(): String {
        return quotes[Random.nextInt(quotes.size)]
    }

    fun getQuoteCount(): Int = quotes.size
}