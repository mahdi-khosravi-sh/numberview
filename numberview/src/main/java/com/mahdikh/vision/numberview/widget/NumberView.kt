package com.mahdikh.vision.numberview.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.Gravity
import com.google.android.material.textview.MaterialTextView
import com.mahdikh.vision.numberview.R
import com.mahdikh.vision.numberview.animator.Animator
import kotlin.math.abs

class NumberView : MaterialTextView {
    val textBounds = Rect()
    var animator: Animator? = null
        set(value) {
            field = value
            field?.numberView = this
        }
    var number = 0
        private set
    var leftDigits = ""
    var rightDigits = ""
    var newRightDigits = ""
    var leftDigitsWidth = 0.0F

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        gravity = 0
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.NumberView, defStyleAttr, 0)

            val count = a.indexCount
            var index: Int
            for (i in 0 until count) {
                index = a.getIndex(i)
                when (index) {
//                    R.styleable.NumberView_duration -> {
//                        duration = a.getInt(index, 250)
//                    }
//                    R.styleable.NumberView_interpolator -> {
//                        val id = a.getResourceId(index, -1)
//                        interpolator = InterpolatorCompat.getInterpolatorById(id)
//                    }
                    R.styleable.NumberView_number -> {
                        val value = a.getInt(index, 0)
                        setNumber(value, false)
                    }
                }
            }
            a.recycle()
        }
    }

    override fun setGravity(gravity: Int) {
        super.setGravity(Gravity.LEFT or Gravity.CENTER_VERTICAL)
    }

    fun increment() {
        setNumber(number + 1, true)
    }

    fun increment(step: Int) {
        setNumber(number + step, true)
    }

    fun increment(animate: Boolean) {
        setNumber(number + 1, animate)
    }

    fun increment(step: Int, animate: Boolean) {
        setNumber(number + step, animate)
    }

    fun decrement() {
        setNumber(number - 1, true)
    }

    fun decrement(step: Int) {
        setNumber(number - step, true)
    }

    fun decrement(animate: Boolean) {
        setNumber(number - 1, animate)
    }

    fun decrement(step: Int, animate: Boolean) {
        setNumber(number - step, animate)
    }

    fun setNumber(number: Int) {
        setNumber(number, true)
    }

    fun setNumber(number: Int, animate: Boolean) {
        if (this.number == number) {
            return
        }
        setStringParts(number)
        updateText(number, animate)
        this.number = number
    }

    private fun setNumber(str: String) {
        setNumber(str, true)
    }

    private fun setNumber(str: String, animate: Boolean) {
        val digits = findDigits(str)
        if (digits.isNotEmpty()) {
            setNumber(digits.toInt(), animate)
        }
    }

    private fun findDigits(str: String): String {
        val builder = StringBuilder()
        str.toCharArray().forEach {
            if (Character.isDigit(it)) {
                builder.append(it)
            }
        }
        return builder.toString()
    }

    private fun setStringParts(newNumber: Int) {
        val oldStr = abs(number).toString()
        val newStr = abs(newNumber).toString()

        /*
         * اگر علامت عدد قبلی با فعلی یکسان نباشد بدین معناست که عدد فعلی دارای علامتی عکس علامت عدد قبلی است
         * لذا در این شرایط تمامی ارقام دارای انیمیشن هستند
         *
         * اگر تعداد رقم های عدد قبلی با عدد جدید یکسان نباشد در این هنگام نیز تمامی رقم ها دارای انیمیشن هستند
         * */

        /*
         * اگر علامت عدد قبلی با فعلی یکسان نباشد بدین معناست که عدد فعلی دارای علامتی عکس علامت عدد قبلی است
         * لذا در این شرایط تمامی ارقام دارای انیمیشن هستند
         *
         * اگر تعداد رقم های عدد قبلی با عدد جدید یکسان نباشد در این هنگام نیز تمامی رقم ها دارای انیمیشن هستند
         * */
        if (isPositive(number) != isPositive(newNumber) || oldStr.length != newStr.length) {
            leftDigits = ""
            rightDigits = number.toString()
            newRightDigits = newNumber.toString()
        } else {
            /*
                اگر برنامه وارد این بدنه شود به این معناست که علامت عدد تغییری نکرده و همینطور عدد قبلی و فعلی دارای
                تعداد رقم های یکسانی هستند
                */
            val length = oldStr.length
            for (i in 0 until length) {
                if (oldStr[i] != newStr[i]) {
                    /*
                     * اگر شرط true شد به این معناست که شاخص سمت چپ ترین رقمی که تغییر کرده همان مقدار i است
                     * */
                    leftDigits = newStr.substring(0, i)
                    if (!isPositive(newNumber)) {
                        leftDigits = "-${leftDigits}"
                    }
                    newRightDigits = newStr.substring(i, length)
                    rightDigits = oldStr.substring(i, length)
                    break
                }
            }
        }
        val textPaint = paint
        leftDigitsWidth = textPaint.measureText(leftDigits)

        val completeText = getCompleteText()
        textPaint.getTextBounds(completeText, 0, completeText.length, textBounds)
    }

    private fun updateText(number: Int, animate: Boolean) {
        if (animate) {
            animator?.run {
                animate(number)
                return@updateText
            }
        }
        joinRightParts()
        setCompleteText()
    }

    private fun isPositive(a: Int): Boolean {
        return a >= 0
    }

    fun setCompleteText() {
        super.setText(getCompleteText(), BufferType.NORMAL)
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        post {
            setNumber(text.toString(), false)
        }
    }

    override fun getText(): CharSequence {
        return getCompleteText()
    }

    private fun getCompleteText(): String {
        return leftDigits + newRightDigits
    }

    fun getTextHeight(): Int {
        return textBounds.height()
    }

    override fun onDraw(canvas: Canvas) {
        animator?.let {
            paint.color = currentTextColor
            paint.drawableState = drawableState
            it.draw(canvas, paint)
        } ?: kotlin.run { super.onDraw(canvas) }
    }

    fun joinRightParts() {
        rightDigits = newRightDigits
    }
}