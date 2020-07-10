package com.example.android02kotlin.aaa

class Test16AAA {
    var name:String = "kim"
    var age:Int = 33

    fun sleep():Unit{
        println("sleep().....")
    }

    fun sleep2() = println("sleep2()...")

    var sleep3 = {println("sleep3()...")}

    fun getColor():Int{
        return 111
    }

    fun getColor2() = 256
    var getcolor3 = {0}

}