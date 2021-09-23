package com.mahdikh.vision.numberview.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint
import androidx.annotation.CallSuper
import com.mahdikh.vision.numberview.widget.NumberView

abstract class Animator {
    internal lateinit var numberView: NumberView
    var valueAnimator = ValueAnimator()
        private set
    var y: Float = 0.0F
        private set
    var x: Float = 0.0F
        private set

    private var isEndHide = false

    private val listener = object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            isEndHide = false
            onEndShow()
        }
    }

    private val updateListener = ValueAnimator.AnimatorUpdateListener {
        val fraction = it.animatedFraction
        if (fraction >= 0.5F && !isEndHide) {
            onEndHide()
            isEndHide = true
        }
        onAnimationUpdate(fraction, it.animatedValue)
    }

    init {
        valueAnimator.addListener(listener)
        valueAnimator.addUpdateListener(updateListener)
    }

    open fun onUpdateNumber(newNumber: Int) {

    }

    @CallSuper
    open fun animate(newNumber: Int) {
        isEndHide = false
        valueAnimator.start()
    }

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

    open fun onAnimationUpdate(fraction: Float, animatedValue: Any) {
        numberView.invalidate()
    }

    open fun onEndHide() {
        numberView.setCompleteText()
    }

    open fun onEndShow() {

    }

    open fun setDuration(duration: Long) {
        valueAnimator.duration = duration
    }

    open fun setInterpolator(interpolator: TimeInterpolator?) {
        valueAnimator.interpolator = interpolator
    }

    fun setFloatValues(vararg values: Float) {
        valueAnimator.setFloatValues(*values)
    }

    fun setIntValues(vararg values: Int) {
        valueAnimator.setIntValues(*values)
    }

    fun getAnimatedValue(): Any {
        return valueAnimator.animatedValue
    }
}