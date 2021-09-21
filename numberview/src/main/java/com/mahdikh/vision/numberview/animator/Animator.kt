package com.mahdikh.vision.numberview.animator

import android.animation.TimeInterpolator
import android.graphics.Canvas
import android.text.TextPaint
import com.mahdikh.vision.numberview.widget.NumberView

abstract class Animator {
    internal lateinit var numberView: NumberView
    var interpolator: TimeInterpolator? = null
    var duration: Long = 250
    var y: Float = 0.0F
    var x: Float = 0.0F

    abstract fun updateText(newNumber: Int)

    open fun draw(canvas: Canvas, paint: TextPaint) {
        y = numberView.height / 2f + numberView.getTextHeight() / 2f
        x = numberView.compoundPaddingLeft.toFloat()

        onDrawLeftDigits(canvas, paint)
        onDrawRightDigits(canvas, paint)
    }

    open fun onDrawLeftDigits(canvas: Canvas, paint: TextPaint) {
        canvas.drawText(
            numberView.leftDigits, x, y, paint
        )
    }

    open fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        canvas.drawText(
            numberView.rightDigits,
            x + numberView.leftDigitsWidth, y,
            paint
        )
    }

    fun invalidate() {
        numberView.invalidate()
    }
}