package com.example.android02kotlin

import kotlin.random.Random

fun main(){
    println("function lambda")
    // 함수를 변수에 할당하는 경우

    fun test():Int{
        return 100
    }
    var t = test()  // t에는 100이 들어간것
    // 우리는 var t = test 를 하고싶은것임
    
    // 람다함수는 데이터처럼 변수에 할당이 가능
    // 할당받은 변수는 함수변수가 됨
    // 함수 변수는 call할수있다.

    // input X, output O
    var fn:()->Int = { Random.nextInt(10)}
    // var fn = { Random.nextInt(10)}  // :()->returnType 생략가능
    println(fn())
    println("--------")
    println(run(fn))
    println("--------")

    var fn_1:()->String = { Random.nextInt(10).toString()}
    println(fn())

    // input X, output X
    var fn2:()->Unit = {println("lambda fn2()....")}
    println(fn2())
    println("--------")
    run(fn2)
    println("--------")
    println("**********")
    ({println("lambda fn2()....")})() // 함수가 데이터처럼 쓰인 경우
    println("**********")

    // input O, output X
    // parameter -> return
    var fn3 = {x:Int -> println("lambda fn3()... $x")}
    fn3(100)
    println("**********")
    ({x:Int -> println("lambda fn3()... $x")})(77) // 함수가 데이터처럼 쓰인 경우
    println("**********")

    //var fn4:(Int)->String = {x:Int-> "Kim$x"}
    var fn4 = {x:Int -> "Kim$x"}
    println(fn4(99))


    //var fn4:(Int, Int)->String = {x:Int, y:Int -> "Kim, $x, $y"}
    var fn4_1 = {x:Int, y:Int -> "Kim, $x, $y"}
    println(fn4_1(99, 88))
    println("**********")
    println(({x:Int, y:Int -> "Kim, $x, $y"})(77, 66)) // 함수가 데이터처럼 쓰인 경우
    println("**********")

}
