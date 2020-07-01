package com.example.android02kotlin

fun main() {
    println("arrayOf() 함수...")
    // 선언되어지는 타입에 따라 데이터의 종류가 달라질수있다.
    var datas = arrayOf(1,2,3)
    //var datas:Array<Int> = arrayOf(1,2,3) 에서 타입을 생략
    //arrayOf의 타입이 Array<T> -> <T>에 object타입의 원하는 타입을 기술
    
    datas = arrayOf(4,5,6) // var타입이기때문에 datas의 값을 수정 가능

    println(datas[0])
    println(datas[1])
    println(datas[2])

    println("datas.size : ${datas.size}")  // array의 크기를 받아오는 내부 함수

    // index로 접근
    for(i in 0 until datas.size){
        println(datas[i])
    }
    
    // item으로 접근
    for(i in datas){
        println(i)
    }

    var names:Array<String> = arrayOf("kim", "lee", "yang")
    for(i in 0 until names.size){
        println(names[i])
    }

    for(name in names){  // datas자체를 넣는 경우 name이 index가 아니라 item으로 매칭됨!
        println(name)  // java의 개선된 for문하고 같은 의미
    }

    // 거꾸로 가져오는 경우
    for(i in names.size-1 downTo 0){
        println(names[i])  // 거꾸로 출력하는 경우엔 index만
    }

    var bools:Array<Boolean> = arrayOf(true, false, false)
    for(bool in bools) print("$bool ")
    println()



}