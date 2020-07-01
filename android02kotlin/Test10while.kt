package com.example.android02kotlin

fun main() {
    println("while..........")

    var count:Int = 0
    while(true){    // 일단 무한루프를 돌린 후
        print("$count ")
        count++

        if(count>=5) break  // 원하는 조건을 후술
    }
    println()
    
    var i:Int = 0
    while(i <= 5){    // 조건에서 break를 제어
        print("$i ")
        i++
    }
    println()

    println("do-while======================")

    // do-while
    var x:Int = 0
    //while(x >= 5){ // 하나도 찍지않고 나와버림
    do{  // do block을 한번 실행한 후 조건을 확인
        print("$x ")
        x++
    }while(x >= 5) // do-while문으로 만들면 한번은 실행
    println("end while")

    while(true){
        var x:String? = "x"
        println("$x")
        //x = "end"
        println("종료시 end입력: [아무키 입력시 계속 수행]")
        x = readLine()
        if(x.equals("end")) break
    }
    println("end while")

}