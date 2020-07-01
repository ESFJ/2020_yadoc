package com.example.android02kotlin

import kotlin.random.Random

fun main(){
    println("function lambda")
    // 함수를 함수 인자로 할당하는 경우

//    ({ Random.nextInt(10)})()
//    ({println("lambda fn2....")})()
//    ({x:Int -> println("lambda fn3...$x")})(77)
//    println(({x:Int, y:Int -> "kim$x,$y"})(77,66))

    var arr:Array<Int> = Array(3, {i -> i})
    // Array의 첫번째 인자는 size(=3)이고, 두번째 인자로 lambda식이 들어간 경우

    // start의 인자로 파라미터는 없고 리턴값은 Int인 함수가 들어옴
    fun start(fn:()->Int){
        // 함수는 줄테니 필요할때 call해서 써라
        // 함수는 파라미터로 들어오고 사용은 함수 내에서 필요할때 사용
        var random_num = fn()
        println("random_num : $random_num")
    }
    start({ Random.nextInt(10)})

    // 인자가 없고 리턴도 없는 경우
    fun start2(fn:()->Unit){
        fn()
    }
    start2({println("lambda fn2....")})

    fun start3(fn:(Int)->Unit){
        fn(33)
    }
    start3({x:Int -> println("lambda fn3...$x")})

    fun start4(fn:(Int, Int)->String){
        println(fn(77, 88))
    }
    start4({x:Int, y:Int -> "kim$x,$y"})

    // 미션1
    // 1일때는 합계 (lambda1(2,3))
    // 2일때는 곱 (lambd2(2,3))
    // cal(1or2, lambda1, lambda2)
    // 출력도 할것!
    fun cal(x:Int,
            lambda1:(Int, Int)->Int,
            lambda2:(Int, Int)->Int){
        if(x == 1) println("합 : ${lambda1(2,3)}")
        else if(x == 2) println("곱 : ${lambda2(2,3)}")
        else println("error")
    }
    // cal(1, {x:Int, y:Int -> x+y}, {x:Int, y:Int -> x*y})
    cal(2, {x, y -> x+y}, {x, y -> x*y})  // 위에서 타입 명시해둬서 아래서 생략 가능

    // 미션2
    // size만큼 람다함수가 배열을 반환하고 출력
    // testArray(size, lambda)
//    fun testArray(size:Int, fn:(Int)->Array<Int>){
//        println(fn(size).contentToString())
//    }
//    testArray(10, {Int ->Array(Int, {i -> 0})})

    //fun testArray(i:Int, fn:(Int)->IntArray){
    //testArray(10, {x -> IntArray(x) })
    
    // 메인함수 밖에 정의된 함수도 호출 가능
    testArray(10, {x -> Array<Int>(x, {i -> i}) })

    // 고차함수 또는 일급함수라고 한다.
    // - 함수를 변수에 할당
    // - 함수를 함수의 인자값으로 할당
    // - 함수를 리턴문에 할당
}

// 함수는 함수 밖에 만들어도 되고 안에 만들어도 됨
fun testArray(i:Int, fn:(Int)->Array<Int>){
    println(fn(i).contentToString())
}