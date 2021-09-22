package com.mahdikh.numberview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahdikh.vision.numberview.animator.DefaultAnimator
import com.mahdikh.vision.numberview.widget.NumberView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberView: NumberView = findViewById(R.id.numberView)
        numberView.setOnClickListener {
            numberView.increment()
        }
        numberView.setOnLongClickListener {
            numberView.decrement()
            true
        }
        numberView.animator = DefaultAnimator()
    }
}