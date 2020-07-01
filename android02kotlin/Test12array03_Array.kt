package com.example.android02kotlin

import java.util.*

fun main() {
    println("Array(사이즈, 람다식) 생성자.....")
    // 데이터가 정형화되어있지않고 unique한 경우는 사용불가!
    // auto로 돌려도 간단히 만들수있는 그런 값들에 사용가능
    // lamdba : i -> 식 : i = 0 .. size-1, 식을 수행

    //var sus:Array<Int> = Array(10, {i -> i})  // 들어온 값(i)로 초기화
    //var sus:Array<Int> = Array(10, {i -> 0})  // 0으로 전부 초기화
    var sus:Array<Int> = Array(10, {i -> i*10})  // i * 10을 초기화
    sus.forEach { print("$it ") }
    println()

    //var names:Array<String> = Array(5, {i -> "kim"}) // 전부 kim으로 초기화
    var names:Array<String> = Array(5, {i -> "kim${i+1}"}) // kim1, kim2, kim3...
    names.forEach { print("$it ") }
    println()

    //1 2 3 4 5 : String
    var num:Array<String> = Array(5, {i -> "${i+1}"})
    //var num:Array<String> = Array(5, {i -> (i+1).toString()}) // 둘다 가능
    num.forEach { print("$it ") }
    println()
}