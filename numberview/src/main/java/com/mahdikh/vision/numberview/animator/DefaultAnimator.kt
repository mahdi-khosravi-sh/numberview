package com.mahdikh.vision.numberview.animator

import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint

class DefaultAnimator : Animator() {
    private var rightDigitsAlpha = 255
    private var translationY: Float = 0.0F
    val translationAnimator: ValueAnimator = ValueAnimator()
    val alphaAnimator: ValueAnimator = ValueAnimator()

    override fun updateText(newNumber: Int) {
        val value1 = 0
        val value2 =
            if (newNumber > numberView.number) {
                // incremented
                numberView.getTextHeight()
            } else {
                // decremented
                -numberView.getTextHeight()
            }
        translationAnimator.setFloatValues(value1.toFloat(), value2.toFloat())
        translationAnimator.duration = duration / 2
        translationAnimator.interpolator = interpolator
        translationAnimator.addUpdateListener { animation: ValueAnimator ->
            translationY = animation.animatedValue as Float
            invalidate()
        }

        alphaAnimator.setIntValues(255, 0)
        alphaAnimator.duration = duration / 3
        alphaAnimator.addUpdateListener { animation: ValueAnimator ->
            rightDigitsAlpha = animation.animatedValue as Int
        }

        translationAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator) {
                numberView.setCompleteText()
                translationAnimator.removeListener(this)
                translationAnimator.setFloatValues(-value2.toFloat(), value1.toFloat())
                alphaAnimator.setIntValues(0, 255)
                /*
                 * زمانی که رقم های عدد قدیمی مخفی شدند اکنون باید رقم های عدد جدید نمایان شوند
                 * */
                numberView.joinRightParts()
                alphaAnimator.start()
                translationAnimator.start()
            }
        })
        alphaAnimator.start()
        translationAnimator.start()
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = rightDigitsAlpha
        canvas.save()
        canvas.translate(0.0F, translationY)
        super.onDrawRightDigits(canvas, paint)
        canvas.restore()
        paint.alpha = 255
    }
}