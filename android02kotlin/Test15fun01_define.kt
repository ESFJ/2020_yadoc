package com.example.android02kotlin

// console에서 하는 경우 인자를 줄수있음
fun main(){
    println("function")

    fun fn1():Unit{
        println("fn1()....")
    }

    // overLoading
    fun fn1(x:Int):Unit{
        println("fn1(x:Int)....")
    }

    fn1()
    fn1(100)

    fun fn2():Int{
        println("fn2: Int")
        return 100
    }
    var x = fn2()
    println("X: $x")

    fun fn3(arr:Array<String>):String{
        println("fn3(arr:Array<String>):String")
        return arr[0]
    }
    println(fn3(arrayOf("kim", "lee", "park")))

}
