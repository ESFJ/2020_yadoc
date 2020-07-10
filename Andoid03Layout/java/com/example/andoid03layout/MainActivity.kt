package com.example.andoid03layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class MainActivity : AppCompatActivity() {
    // onCreate를 main이라고 생각하면 됨
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)  // static으로 올라감 (xml로 설정된 것들은 거의 다 static으로 올라감)
        setContentView(R.layout.activity_sub)  // static으로 올라감 (xml로 설정된 것들은 거의 다 static으로 올라감)
        button_left.setOnClickListener {
            tv_title.text = et_name.text
        }
        
        check_job1.setOnCheckedChangeListener { compoundButton, b ->
            Log.i("testLog", compoundButton.isChecked.toString())
        }

        switch1.setOnCheckedChangeListener { compoundButton, b ->
            Log.i("testLog", compoundButton.isChecked.toString())
        }
//        Log.i("testLog", "onCreate()...${tv01.text}")  // logcat에서 확인 가능
//        // tv01이 대상이면서 변수이기 때문에 바로 값을 넣을 수 있다.
////        tv01.text = R.string.app_name2.toString()  // R.string.app_name2 : 상수값
//        tv01.text = getString(R.string.app_name)
//
//        button1.setOnClickListener {
//            tv01.text = getString(R.string.app_name2)
//        }
//
//        button2.setOnClickListener {
//            tv01.text = getString(R.string.app_name)
//        }

    }  // end onCreate()
}  // end class