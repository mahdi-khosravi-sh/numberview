package com.mahdikh.vision.numberview.animator

import android.graphics.Rect

abstract class PivotAnimator : Animator() {
    private val rect: Rect = Rect()

    override fun onUpdateNumber(newNumber: Int) {
        numberView.paint.getTextBounds(
            numberView.rightDigits, 0,
            numberView.rightDigits.length, rect
        )
    }

    fun getRightDigitCenterX(): Float {
        return numberView.compoundPaddingLeft + numberView.leftDigitsWidth + rect.width() / 2F
    }

    fun getRightDigitCenterY(): Float {
        return y + rect.top + rect.height() / 2F
    }

    fun getRightWidth(): Int {
        return rect.width()
    }

    fun getHeight(): Int {
        return rect.height()
    }
}