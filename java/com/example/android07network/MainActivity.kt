package com.example.android07network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread(){
            testURL()
        }.start()
    }

    fun testURL(){
        // thread 처리
        val url = URL("http://192.168.0.9/kotlinProject/test.json")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")

        if(conn.responseCode == 200){
            println("=============url.readText()============")
            val txt = url.readText()
            println(txt)

            var title = ""
            // 분석 : 데이터 파싱
            val arr = JSONArray(txt)
            for(i in 0 until arr.length()){
                val obj:JSONObject = arr.get(i) as JSONObject
                Log.i("testLog", "${obj["name"]} , ${obj["age"]}")
                title += "${obj["name"]} , ${obj["age"]}\n"
            }

            // 별도의 스레드 처리 필요
            handler.post{
                // 스레드가 다 끝나야 이 블럭을 실행
                tv_title.text = title
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // multi permission logic
    }
}