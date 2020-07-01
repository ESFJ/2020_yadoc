package com.example.android02kotlin

// console에서 하는 경우 인자를 줄수있음
fun main(){
    println("function define2")

    // 간단한 함수 (1줄짜리) 작성시 함수 간소화 가능
    fun fn(x:Int, y:Int) = x+y
    println(fn(10,20))

    fun fn2(x:Int, y:Int) = if(x>y) "big" else "small"
    println(fn2(10,20))

    // 함수 내부에서 함수 call 가능
    fun fn3(x:Int, y:Int) = if(fn(15, 25)>20) "big" else "small"
    println(fn3(10,20))

    fun fn4(x:Int) = when(x){
        in 90..100 -> "A"
        in 80..89 -> "B"
        else -> "F"
    }
    println(fn4(90))
}
