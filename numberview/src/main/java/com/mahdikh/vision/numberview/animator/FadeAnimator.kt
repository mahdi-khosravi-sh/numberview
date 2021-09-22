package com.mahdikh.vision.numberview.animator

import android.graphics.Canvas
import android.text.TextPaint

class FadeAnimator : Animator() {
    private var alpha = 255

    override fun animate(newNumber: Int) {
        setIntValues(255, 0, 0, 255)
        super.animate(newNumber)
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        alpha = animatedValue as Int
        super.onAnimationUpdate(fraction, animatedValue)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = alpha
        super.onDrawRightDigits(canvas, paint)
        paint.alpha = 255
    }
}