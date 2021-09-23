package com.mahdikh.vision.numberview.animator

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint
import android.util.LayoutDirection
import android.view.Gravity

class SlideAnimator : PivotAnimator {
    private var alpha = 255
    private var translationY: Float = 0.0F
    private val alphaAnimator = ValueAnimator()
    var gravity: Int = Gravity.BOTTOM

    constructor() : super()

    constructor(gravity: Int) : super() {
        this.gravity = gravity
    }

    override fun setDuration(duration: Long) {
        super.setDuration(duration)
        alphaAnimator.duration = duration
    }

    private fun getRightValue(newNumber: Int): Int {
        return if (newNumber > numberView.number) {
            getRightWidth()
        } else {
            -getRightWidth()
        }
    }

    private fun getBottomValue(newNumber: Int): Int {
        return if (newNumber > numberView.number) {
            getHeight()
        } else {
            -getHeight()
        }
    }

    private fun computeAnimatorValue(newNumber: Int): Float {
        return when (gravity) {
            Gravity.RIGHT -> {
                getRightValue(newNumber)
            }
            Gravity.LEFT -> {
                -getRightValue(newNumber)
            }
            Gravity.START -> {
                if (numberView.layoutDirection == LayoutDirection.RTL) {
                    getRightValue(newNumber)
                } else {
                    -getRightValue(newNumber)
                }
            }
            Gravity.END -> {
                if (numberView.layoutDirection == LayoutDirection.RTL) {
                    -getRightValue(newNumber)
                } else {
                    getRightValue(newNumber)
                }
            }
            Gravity.BOTTOM -> {
                getBottomValue(newNumber)
            }
            Gravity.TOP -> {
                -getBottomValue(newNumber)
            }
            else -> {
                if (Gravity.isHorizontal(gravity)) {
                    getRightValue(newNumber)
                } else {
                    getBottomValue(newNumber)
                }
            }
        }.toFloat() / 2.0F
    }

    override fun animate(newNumber: Int) {
        val value2 = computeAnimatorValue(newNumber)
        setFloatValues(0.0F, value2, -value2, 0.0F)
        alphaAnimator.setIntValues(255, 0, 0, 0, 255)
        alphaAnimator.start()
        super.animate(newNumber)
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = alpha
        canvas.save()
        if (gravity == Gravity.TOP || gravity == Gravity.BOTTOM) {
            canvas.translate(0.0F, translationY)
        } else {
            canvas.translate(translationY, 0.0F)
        }
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