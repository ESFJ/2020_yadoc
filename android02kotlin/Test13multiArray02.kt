package com.example.android02kotlin

import java.util.*

fun main() {
    println("다차원 배열....")

    // [["kim", "lee", "han"], ["kim", "lee", "han"]]
    // var names:Array<Array<String>> = arrayOf(arrayOf("kim", "lee", "han"), arrayOf("kim", "lee", "han"))

    val names1 = arrayOf("kim", "lee", "han")
    val names2 = arrayOf("kim", "lee", "han")
    val namess:Array<Array<String>> = arrayOf(names1, names2)
    println(Arrays.deepToString(namess))

    // [["kim1", "lee1", "han1"], ["kim2", "lee2", "han2"]]
    // var names22:Array<Array<String>> = arrayOf(arrayOf("kim1", "lee1", "han1"), arrayOf("kim2", "lee2", "han2"))
//    for(i in 0..1){
//        for(j in 0..2){
//            names[i][j] = names[i][j]+(i+1)
//        }
//    }

    // EL을 이용해 간단하게 이름 뒤에 숫자 붙이기
    val namess2:Array<Array<String>?> = arrayOfNulls<Array<String>>(2)
    for(i in 0 until namess2.size){
        namess2[i] = arrayOf("kim${i+1}", "lee${i+1}", "han${i+1}")
    }
    
    //배열 출력하기
    // Arrays의 함수 사용하기
    println(Arrays.deepToString(namess2))
    println(Arrays.deepToString(namess2[0]))  // 0번 array의 값만 출력

    //namess2가 가진 ToString 함수 이용하기
    println(namess2.contentDeepToString())
    println(namess2[0]!!.contentDeepToString())  // 0번 array의 값만 출력 ( !! : non-null)
    
    println(namess2[0]!!.first())
    println(namess2[0]!!.last())
    println()
    
    // 원본을 복사후 원하는 데이터를 추가해 새로운 배열을 만들어줌
    println(namess2[0]!!.plus("yangssem").contentDeepToString())
    
    // lee1가 몇번 인덱스에 있나
    println(namess2[0]!!.indexOf("lee1"))


}