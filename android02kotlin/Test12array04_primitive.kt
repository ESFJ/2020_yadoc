package com.example.android02kotlin

import java.util.*

fun main() {
    println("원시타입(primitive Type) 함수...")

    // 이번은 Int타입을 받는 Array type이 아닌 처음부터 IntArray
    //var sus:IntArray = IntArray(10,{i -> i*10})  // 이건 생성자
    var sus:IntArray = IntArray(10)  // 아무것도 안적으면 0 (기본값)9
    sus.forEach { print("$it ") }
    println()

    // intArrayOf의 타입도 IntArray
    var sus2:IntArray = intArrayOf(11,22,33)  // 이건 함수
    sus2.forEach { print("$it ") }
    println()

    // 물론 type생략도 가능
    var ds = DoubleArray(5, {i -> i*1.0}) // lamdba : int_index -> double value
    ds.forEach { print("$it ") }
    println()

    var ds2:DoubleArray = doubleArrayOf(1.1, 1.2, 1.3)
    ds2.forEach { print("$it ") }
    println()

    var cs = CharArray(5)
    for(item in cs) print("$item,") //char의 기본은 공백하나
    println()

    var bs = BooleanArray(5)
    for(item in bs) print("$item,") // 0에 해당하는 false가 기본값
    println()
}