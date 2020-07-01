package com.example.android02kotlin

import kotlin.random.Random

fun main(){
    println("function lambda")
    // 함수를 데이터처럼 함수의 리턴값으로 할당하는 경우

//    ({ Random.nextInt(10)})()
//    ({println("lambda fn2....")})()
//    ({x:Int -> println("lambda fn3...$x")})(77)
//    println(({x:Int, y:Int -> "kim$x,$y"})(77,66))

    fun start1():()->Int{
        return { Random.nextInt(10)}
    }
    println(start1()())

    fun start2():()->Unit{
        return {println("lambda fn2....")}
    }
    println(start2()())

    fun start3():(Int)->Unit{
        return {x:Int -> println("lambda fn3...$x")}
    }
    println(start3()(88))

    fun start4():(Int, Int)->String{
        return {x:Int, y:Int -> "kim$x,$y"}
    }
    println(start4()(67,67))
    
//    fun test(){
//        fun fn(){
//
//        }
//        return fn  // 이렇게 안에서 만든 함수를 바로 리턴할순없어서 람다를 사용함
//    }



}