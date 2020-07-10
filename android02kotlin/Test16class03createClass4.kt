package com.example.android02kotlin

fun main() {
    println("create class4")
    //생성자 오버로딩 : 파라미터의 갯수, 타입, 순서가 다르면 여러 생성자를 정의할 수 있다.

    val board = Test16Board()
    println(board)

    val board2 = Test16Board(99)
    println(board2)

    val board3 = Test16Board("Kotlin")
    println(board3)

    val board4 = Test16Board(88, "Kotlin88")
    println(board4)
}

class Test16Board{
    var num:Int = 0
    var title:String = "title"
    constructor(){
        num = 1
    }
    constructor(num:Int){
        this.num = num
    }
    constructor(title:String){
        this.title = title
    }
    constructor(num:Int, title:String){
        this.num = num
        this.title = title
    }

    override fun toString(): String {
        return "Test16Board(num=$num, title='$title')"
    }


}