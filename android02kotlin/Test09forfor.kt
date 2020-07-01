package com.example.android02kotlin

fun main() {
    println("for... for..")

    //0~9
    //0~9
    //0~9 세번 찍기
    for(i in 0..2){
        for(j in 0 until 10)
            print("$j ")
        println()
    }
    println()

    //구구단 찍기
    // 2단~9단, 각 곱은 1~9
    // 2*1=2, 2*2=4, ....., 2*9=18
    // ...
    // 9*1=9, 9*2=18, ...., 9*9=81
    for(i in 2 until 10){  // 2..9로 대체 가능
        for(j in 1 until 10){
            print("$i*$j=${i*j}")
            if(j == 9) continue
            print(", ")
        }
        println()
    }
    println()

    //break문을 이용하여 5단까지만 출력
    for(i in 2 until 10){  // 2..9로 대체 가능
        for(j in 1 until 10){
            print("$i*$j=${i*j}")
            if(j == 9) continue
            print(", ")
        }
        if(i == 5) break
        println()
    }
    println()

    println("label")
    //label 사용하기
    loop1@for(i in 2 until 10){  // 2..9로 대체 가능
        for(j in 1 until 10) {
            print("$i*$j=${i * j}")
            if (j == 9) continue
            print(", ")
            //if(i==5) break@loop1
            if(i==5) continue@loop1
        }
        println()
    }
    println()
}