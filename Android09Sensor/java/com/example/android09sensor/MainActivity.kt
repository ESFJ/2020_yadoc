package com.example.android09sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SensorEventListener {

    // 다른 곳에서도 사용하려고 전역변수
    var sm:SensorManager? = null
    var strs:Array<String>? = null
    var ran:Random? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        strs = arrayOf("가위", "바위", "보")
        ran = Random

        // 센서를 이용해 값 바꾸기
        tv_title.text = "가위바위보 시작!\n화면을 흔들어주세용"

//        sm = this.getSystemService(Context.SENSOR_SERVICE)
        sm = getSystemService(SENSOR_SERVICE) as SensorManager
        
        // 근접센서 사용하기
        var list:MutableList<Sensor> = sm!!.getSensorList((Sensor.TYPE_PROXIMITY))
        
        // 가속 센서 사용하기
//        var list:MutableList<Sensor> = sm!!.getSensorList((Sensor.TYPE_ACCELEROMETER))

        Log.i("testLog", "list.size : ${list.size}")
        for(sensor in list){
            Log.i("testLog", "Sensor name : ${sensor.name}")
        }

        // 사용할 센서, 센서의 정밀도를 가진 상수값,
        sm!!.registerListener(this, list.get(0), SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("testLog", "Stop Sensor...")

        // this가 activity도 나지만 sensor event listener도 나임 (상속받았으니까 둘다 내 타입이 됨)
        sm!!.unregisterListener(this)

    }
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
//        if(event?.values!![0] >= 12 || event?.values!![1] >= 12 || event?.values!![2] >= 12){
//            Log.i("testLog", "x : ${event?.values!![0]}, y : ${event?.values!![1]}, z : ${event?.values!![2]}")
//            var i:Int = Random.nextInt(0,3)
//            tv_title.text = if(i == 0){
//                "가위"
//            } else if(i == 1){
//                "바위"
//            } else{
//                "보"
//            }
//            tv_title.text = strs?.get(ran!!.nextInt(3)).toString()
//        }

        // using proximity

        if(event?.values!![0] >= 10) tv_title.text = strs?.get(ran!!.nextInt(3)).toString()
//        Log.i("testLog", "proxy [0] : ${event?.values!![0]}")
    }
}