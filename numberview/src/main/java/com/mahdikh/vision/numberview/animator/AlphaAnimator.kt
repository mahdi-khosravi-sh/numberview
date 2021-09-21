package com.mahdikh.vision.numberview.animator

import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.text.TextPaint

class AlphaAnimator : Animator() {
    private var rightDigitsAlpha = 255
    private val animator: ValueAnimator = ValueAnimator()

    override fun updateText(newNumber: Int) {
        animator.setIntValues(255, 0)
        animator.duration = duration / 2
        animator.interpolator = interpolator
        animator.addUpdateListener {
            rightDigitsAlpha = it.animatedValue as Int
            invalidate()
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator?) {
                numberView.setCompleteText()
                numberView.joinRightParts()
                animator.setIntValues(0, 255)

                animator.removeAllListeners()
                animator.start()
            }
        })
        animator.start()
    }

    override fun onDrawRightDigits(canvas: Canvas, paint: TextPaint) {
        paint.alpha = rightDigitsAlpha
        super.onDrawRightDigits(canvas, paint)
        paint.alpha = 255
    }
}