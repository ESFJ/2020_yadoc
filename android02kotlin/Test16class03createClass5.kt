package com.example.android02kotlin

fun main() {
    println("create class5")
    //this() 생성자

    var board = Test16Board2()
    println(board)

    val board2 = Test16Board2(99)
    println(board2)

    val board3 = Test16Board2("Kotlin")
    println(board3)

    val board4 = Test16Board2(88, "Kotlin88")
    println(board4)
}

class Test16Board2{
    var num:Int = 0
    var title:String = "title"
    constructor():this(0, "title"){
        num = 1
    }
    constructor(num:Int){
        this.num = num
    }
    constructor(title:String):this(){
        this.title = title
    }
    constructor(num:Int, title:String):this(num){
        // this(num)을 이용해 num값을 초기화하겠다는 얘기
        //this.num = num
        this.title = title
    }
    override fun toString(): String {
        return "Test16Board2(num=$num, title='$title')"
    }


}