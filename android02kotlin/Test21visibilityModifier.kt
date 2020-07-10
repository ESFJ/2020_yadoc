package com.example.android02kotlin

import com.example.android02kotlin.aaa.Test21CCC
import com.example.android02kotlin.aaa.Test21DDD

fun main() {
    println("Visibility Modifier")
    // 접근제한자
    // private
    // public or internal

    // private class가 메인함수와 동일한 파일에 존재시 접근 가능
    var a = Test21AAA()
    
    // private class가 메인함수와 다른 파일에 존재시 접근 불가능
//    var b = Test21BBB()

    // internal class도 다른 패키지에 있어도 접근 가능
    // 동일 모듈(같이 컴파일되는 모든 곳)
    var c = Test21CCC()

    var d = Test21DDD()
//    println(d.d1)  // protected
//    println(d.d2)  // private
    println(d.d3)  // public -> d3 접근가능
    println(d.d4)  // internal -> d4 접근가능 (동일 모듈)
//    d.test1() 
//    d.test2() // protected, private 접근 불가
    d.test3()
    d.test4()  // internal, public만 접근 가능
}

private class Test21AAA{

}

class Test21EEE : Test21DDD(){
    fun eee(){
        println(d1)
    }
}