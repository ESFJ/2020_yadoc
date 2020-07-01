package com.example.android02kotlin

fun main() {
    println("data class copy")
    val a1 = AAA()
    println(a1)
    val a2 = AAA(age = 33)
    println(a2)

    val a3 = a1.copy(age = 44)  // age만 바꾸고 a1을 copy
    println(a3)

    val a4 = a1.copy()
    println(a4)

    println(a1 == a4)
    
    println("data class componentN")
    // 객체의 속성을 분리해서 여러 변수에 직접 할당
    var (name, age) = AAA("kim", 33)
    println(name)
    println(age)


}

data class AAA(val name:String="admin", val age:Int=0)