package com.mahdikh.vision.numberview.animator

import android.graphics.Canvas
import android.text.TextPaint

class RotationAnimator : PivotAnimator() {
    private var rotation = 0.0F
    var factor = 1.0F

    override fun animate(newNumber: Int) {
        setFloatValues(0.0F, 30F, -30F, 5F, -5F, 0F)
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        canvas.save()
        canvas.rotate(rotation, getRightDigitCenterX(), getRightDigitCenterY())
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        rotation = animatedValue as Float * factor
        super.onAnimationUpdate(fraction, animatedValue)
    }
}