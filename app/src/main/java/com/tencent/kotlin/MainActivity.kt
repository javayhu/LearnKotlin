package com.tencent.kotlin

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var id:Int? = null
        savedInstanceState?.let {
            id = savedInstanceState.getInt("id", -1)
        }

        demoTextView.apply {
            setTextColor(Color.BLUE)
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)
        }.also {
            Log.i(TAG, "demo text view content: ${it.text}")
        }
    }
}
