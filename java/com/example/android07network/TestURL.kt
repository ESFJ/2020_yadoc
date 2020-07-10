package com.example.android07network

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main() {

    // request URL
    // http://192.168.0.9/kotlinProject/test.json
    val url = URL("http://192.168.0.9/kotlinProject/test.json")
    val conn = url.openConnection() as HttpURLConnection // casting
//    Log.i("testLog", "conn.responseCode : ${conn.responseCode}")
    println("conn.responseCode : ${conn.responseCode}")
    println("conn.contentType : ${conn.contentType}")
    println("conn.content : ${conn.content}")
    println("conn.responseMessage : ${conn.responseMessage}")
    println("conn.inputStream : ${conn.inputStream}")

    // 정확이 내용이 text임을 아는 경우의 파일 읽기
    if(conn.responseCode == 200){
        println("===========url.readText()============")
        println(url.readText())
    }
    
        // 전통적인? 방법의 파일 읽기
    if(conn.responseCode == 200){
        // 정상 응답이 나왔을 경우에만 파싱
        val inputStream:InputStream = conn.inputStream
        val inputStreamReder:InputStreamReader = InputStreamReader(inputStream)
        val br =  BufferedReader(inputStreamReder)
        // text, input stream 등을 읽어들이는 IO 3총사 (안에 들은 내용을 읽을 수 있다.)
        //println("한줄읽기:${br.readLine()}")

        // 내가 짠 부분
//        var txt:String? = ""
//        br.forEachLine {
//            println("$it")
//            txt += it.toString()
//        }
//        println("txt : " + txt)

        // 강사님이 알려주신 정석
//        var txt:String? = ""
//        var tmp:String? = ""
//        while(true){
//            tmp = br.readLine()
//            if(tmp == null) break
//            println(tmp)
//            txt += tmp
//        }
//        println("==================")
//        println(txt)

        // txt를 가지고 분석 (파싱)하면 된다.
    }




}