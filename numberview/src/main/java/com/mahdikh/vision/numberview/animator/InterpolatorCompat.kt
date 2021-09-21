package com.mahdikh.vision.numberview.animator

import android.view.animation.*
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator

class InterpolatorCompat {
    companion object {
        @JvmStatic
        fun getInterpolatorById(interpolatorId: Int): Interpolator? {
            return when (interpolatorId) {
                android.R.interpolator.linear_out_slow_in -> {
                    LinearOutSlowInInterpolator()
                }
                android.R.interpolator.fast_out_linear_in -> {
                    FastOutLinearInInterpolator()
                }
                android.R.interpolator.bounce -> {
                    BounceInterpolator()
                }
                android.R.interpolator.overshoot -> {
                    OvershootInterpolator()
                }
                android.R.interpolator.anticipate_overshoot -> {
                    AnticipateOvershootInterpolator()
                }
                android.R.interpolator.fast_out_slow_in -> {
                    FastOutSlowInInterpolator()
                }
                android.R.interpolator.anticipate -> {
                    AnticipateInterpolator()
                }
                android.R.interpolator.accelerate_decelerate -> {
                    AccelerateDecelerateInterpolator()
                }
                android.R.interpolator.decelerate_cubic -> {
                    DecelerateInterpolator(1.5f)
                }
                android.R.interpolator.decelerate_quad -> {
                    DecelerateInterpolator()
                }
                android.R.interpolator.decelerate_quint -> {
                    DecelerateInterpolator(2.5f)
                }
                android.R.interpolator.linear -> {
                    LinearInterpolator()
                }
                android.R.interpolator.cycle -> {
                    CycleInterpolator(1.0f)
                }
                else -> null
            }
        }
    }
}