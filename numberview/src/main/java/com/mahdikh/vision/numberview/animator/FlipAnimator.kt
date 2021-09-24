package com.mahdikh.vision.numberview.animator

import android.graphics.Canvas
import android.text.TextPaint

class FlipAnimator : PivotAnimator {
    private var scale = 1.0F
    var axis: Int = AXIS_Y

    constructor() : super()

    constructor(axis: Int) : super() {
        this.axis = axis
    }

    override fun animate(newNumber: Int) {
        setFloatValues(1.0F, 0.0F, 0.0F, 1.0F)
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        canvas.save()
        if (axis == AXIS_Y) {
            canvas.scale(scale, 1.0F, getRightDigitCenterX(), getRightDigitCenterY())
        } else {
            canvas.scale(1.0F, scale, getRightDigitCenterX(), getRightDigitCenterY())
        }
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
    }

    override fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        scale = animatedValue as Float
        super.onAnimationUpdate(fraction, animatedValue)
    }

    companion object {
        const val AXIS_Y = 0
        const val AXIS_X = 1
    }
}