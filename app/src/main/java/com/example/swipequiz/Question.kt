package com.example.swipequiz

data class Question(
    var name: String,
    var trueOrFalse: Boolean
    //@DrawableRes var imageResId: Int
) {
    companion object {
        val Questions = arrayOf(
            "A 'val' and 'var' are the same.",
            "Mobile Application Development grants 12 ECTS.",
            "A Unit in Kotlin corresponds to a void in Java.",
            "In Kotlin 'when' replaces the 'switch' operator in Java."
        )
        val TRUE_FALSE = arrayOf(
            false,
            true,
            true,
            true
        )
    }

    //true false
}

