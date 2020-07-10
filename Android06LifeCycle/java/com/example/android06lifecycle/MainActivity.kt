package com.example.android06lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // 최초로 불릴때 화면 구성
        Log.i("testLog", "onCreate....")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("testLog", "onRestart....")
    }

    override fun onStart() {
        super.onStart()
        Log.i("testLog", "onStart....")
        tv_title.text = "time : ${System.currentTimeMillis()}"
    }

    override fun onResume() {
        super.onResume()
        Log.i("testLog", "onResume....")
    }

    override fun onPause() {
        super.onPause()
        Log.i("testLog", "onPause....")
    }

    override fun onStop() {
        super.onStop()
        Log.i("testLog", "onStop....")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("testLog", "onDestroy....")
    }

    // 화면 돌릴때 주로 사용
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("testLog", "onSaveInstanceState....")
        outState.putString("userName", "kim")
        outState.putInt("userAge", 33)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("testLog", "onRestoreInstanceState....")
        //Log.i("testLog", "${savedInstanceState.getString("userName")}")
        //Log.i("testLog", "${savedInstanceState.getInt("userAge")}")

    }
}