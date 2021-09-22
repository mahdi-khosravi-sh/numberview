package com.mahdikh.vision.numberview.animator

import android.graphics.Canvas
import android.graphics.Rect
import android.text.TextPaint

class FlipAnimator : Animator() {
    private val rect: Rect = Rect()
    private var scale = 1.0F

    override fun animate(newNumber: Int) {
        setFloatValues(1.0F, 0.0F, 0.0F, 1.0F)
        numberView.paint.getTextBounds(
            numberView.rightDigits, 0,
            numberView.rightDigits.length, rect
        )
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        canvas.save()
        canvas.scale(
            scale, 1.0F,
            canvas.width - rect.width() / 2F,
            y + rect.top + rect.height() / 2F
        )
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        scale = animatedValue as Float
        super.onAnimationUpdate(fraction, animatedValue)
    }
}