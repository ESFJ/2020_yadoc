package com.example.android02kotlin

fun main() {
    print('A')
    print('B')
    print('C')
    println()
    println("hello")
    println("hello" + "android")
    println("hello" + "android" + (100 + 200))
    println("${100+200} hello")
    println("hello ${100+200}")
    println("hello ${100==200}")
    println("hello ${8 and 3}")
    println("hello ${8 or 3}")
    println("hello ${8 xor 3}")
    println("hello %d + %d = %d, name:%s, pi = %.2f".format(100,200,300,"kim",3.141592))

    println(3.14)
    println(3.14f)
    println(true)
    println(false)
}
