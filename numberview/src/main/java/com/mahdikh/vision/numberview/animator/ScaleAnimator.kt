package com.mahdikh.vision.numberview.animator

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint

class ScaleAnimator : PivotAnimator {
    private val alphaAnimator = ValueAnimator()
    private var scale = 1.0F
    private var alpha = 255
    var toScale: Float = 0.6F

    constructor() : super()

    constructor(toScale: Float) : super() {
        this.toScale = toScale
    }

    override fun setDuration(duration: Long) {
        super.setDuration(duration)
        alphaAnimator.duration = duration
    }

    override fun animate(newNumber: Int) {
        setFloatValues(1.0F, toScale, toScale, 1.0F)
        alphaAnimator.setIntValues(255, 0, 0, 0, 255)
        alphaAnimator.start()
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = alpha
        canvas.save()
        canvas.scale(scale, scale, getRightDigitCenterX(), getRightDigitCenterY())
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
        paint.alpha = 255
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        scale = animatedValue as Float
        alpha = alphaAnimator.animatedValue as Int
        super.onAnimationUpdate(fraction, animatedValue)
    }
}