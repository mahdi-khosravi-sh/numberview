package com.mahdikh.vision.numberview.animator

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint

class DefaultAnimator : Animator() {
    private var alpha = 255
    private var translationY: Float = 0.0F
    private val alphaAnimator = ValueAnimator()

    override fun setDuration(duration: Long) {
        super.setDuration(duration)
        alphaAnimator.duration = duration
    }

    override fun animate(newNumber: Int) {
        val value2 =
            if (newNumber > numberView.number) {
                numberView.getTextHeight().toFloat() / 2F
            } else {
                -numberView.getTextHeight().toFloat() / 2F
            }
        setFloatValues(0.0F, value2, -value2, 0.0F)
        alphaAnimator.setIntValues(255, 0, 0, 0, 255)
        alphaAnimator.start()
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = alpha
        canvas.save()
        canvas.translate(0.0F, translationY)
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
        paint.alpha = 255
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        translationY = animatedValue as Float
        alpha = alphaAnimator.animatedValue as Int
        super.onAnimationUpdate(fraction, animatedValue)
    }
}