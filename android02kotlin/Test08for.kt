package com.example.android02kotlin

fun main() {
    println("for.......")

    // for문
    // counting이 필요한 경우 for를 사용
    // for(int i=0; i<10; i++) // java식
    for(i in 0..9){
        println("$i")
    }

    for(i:Int in 0..9) print("$i ")
    println()

    // step : i++, i+=2 등 n씩 증가하고싶을때
    for(i:Int in 0..9 step 2) print("$i ")
    println()

    // step : i--
    // range는 작은수에서 큰수로만 가능
    // downTo 사용
    for(i:Int in 9 downTo 0) print("$i ")
    println()

    // step : i-=2
    for(i:Int in 9 downTo 0 step 2) print("$i ")
    println()

    // 배열의 인덱스처럼 사용하고 싶다.
    // [0],[1],......[배열의 사이즈 -1]
    var size = 10
    for(i in 0..size-1) print("$i ")
    println()
    for(i in 0 until size) print("$i ")
    println()

    // 반복문 빠져나가기 : break
    for(i in 0 until size) {
        print("$i ")
        if(i==5) break  // break는 그대로 사용 가능
    }
    println()

    // 원하는 부분만 건너뛰어라 : continue
    // 0 1 2 3 5 6 7 8 9
    for(i in 0 until size){
        if(i == 4) continue  //보통은 내가 원하는 그 상황만 건너뛸때 사용
        print("$i ")
    }
    println()
}