package com.example.android02kotlin

import java.util.*

fun main() {
    println("arrayOf() 함수...")
    //선언되어지는 타입에 따라 데이터의 종류가 달라질수 있다.

    var datas:Array<Any> = arrayOf(1,2,3.14, "kim") // type을 여러개 주려면 Any를 줘야함
    //var datas:Array<*> = arrayOf(1,2,3.14, "kim") // Any와 *는 같은 의미가 됨

    for(data in datas) print("$data ")
    println()

    // forEach() 함수 사용법
    // for문의 반복문을 괄호{}안에 적어줌
    // 예약되어진 변수 it(iterator, item, 요소)필요
    // datas라는 객체안에 있는 함수를 사용해 구현하고싶은 로직을 넣어줌
    datas.forEach { print("$it ") }
    println()

    // deepToString - 배열처럼 text로 보여주는 함수
    println(Arrays.deepToString(datas))
    println()

    // format함수
    // 대신 안에 들은 정보가 뭔지 정확히 알아야함
    println("%5d, %d, %.2f, %s".format(*datas))



}