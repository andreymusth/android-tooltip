package ru.tzkt.tooltip

import android.graphics.drawable.GradientDrawable

class RoundedRectDrawable(color: Int) : GradientDrawable() {

    companion object {

        private const val DEFAULT_CORNER_RADIUS = 16f
    }

    init {
        shape = RECTANGLE
        cornerRadii = floatArrayOf(
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS,
            DEFAULT_CORNER_RADIUS
        )
        setColor(color)
    }
}