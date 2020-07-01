package com.example.android02kotlin

import java.util.*

fun main() {
    println("arrayOfNulls() 함수.....")
    //직접 데이터를 넣고 data type이 같은 경우
    var sus:Array<Int> = arrayOf(1,2,3)

    //println(sus) //[Ljava.lang.Integer;@45ee12a7 -> Integer타입의 배열이라는 뜻

    //sus.forEach { it*2 } // return을 하지 않기때문에 의미없이 실행하는 문장이 됨
    sus.forEach { print("$it ") }
    println()

    sus.forEach { print("${it*2} ") }
    println()

    // size가 n인 null로 채운 Array를 반환
    var nulls:Array<Int?> = arrayOfNulls<Int>(3)
    nulls.forEach { print("$it ") }
    println()

    //indexing 할당
    nulls[0] = 11
    nulls[1] = 111
    nulls[2] = 1111

    //set(index, value) 함수사용
    nulls.set(0,99)
    nulls.forEach { print("$it ") }
    println()

    var names:Array<String?> = arrayOfNulls(5)
    names.forEach { print("$it ") }
    println()

    for(i in 0 until names.size){
        names[i] = "kim $i"
    }
    names.forEach { print("$it ") }
    println()

    names.set(2,"yangssem")
    names.forEach { print("$it ") }
    println()

    // array 생성자 사용


}