package com.example.android02kotlin

fun main() {
    println("interface")

    // kotlin에서  다중상속을 지원한다.

    var store = Test20Store(1000, "red")
    println(store.price)
    println(store.color)
    store.fn1()
    println(store.fn2("lee"))
    println(store.fn3().contentToString())
    store.fn4()
    println(store.fn5({100})(5))
    println(store.fn6())
}

class Test20Store(override var price:Int, override var color:String) : Test20Book, Test20Note{
    // Book의 함수였던 fn1, fn2를 재정의
    override fun fn1() {
        println("Test20Store...fn1()")
    }

    override fun fn2(name: String): String {
        println("Test20Store...fn2() : $name")
        return "Kotlin"
    }

    // Book의 일반함수도 override
    override fun fn3(): Array<Int> {
        println("Test20Store...fn3()")
        return Array<Int>(10, {i->i})
    }

    override fun fn4() {
        println("Test20Store...fn4()")
    }

    override fun fn5(fn: () -> Int): (Int) -> String {
        println("Test20Store...fn5() : ${fn()}")
        return {x -> "Yang"}
    }
}

interface Test20Book /*constructor() 사용불가!*/{
//    constructor()  // 사용 불가. 즉 생성자를 가질수없다
//    var price:Int = 1000  // 변수 초기화 불가
    var price:Int  // 선언만 가능하며 초기화는 상속받은 클래스에서 가능

    //함수 정의부 블럭이 생략되면 무조건 추상함수고 abstrac 생략
    // open도 생략
    /*open*/ /*abstract*/ fun fn1():Unit
    fun fn2(name:String):String

    /*open*/ fun fn3():Array<Int>{
        return arrayOf(1,2,3)
    }  // 일반함수도 open을 안써도 무조건 재정의 가능
}

// 공책이라는 인터페이스를 정의하고
// 속성은 색상
// 기능은 기능4-추상, 기능5-추상, 기능6-일반
// 스토어 클래스가 공책 인터페이스를 상속받게하시오

interface Test20Note{
    var color:String
    fun fn4():Unit
    fun fn5(fn:()->Int):(Int)->String
    fun fn6():String{
        println("Test20Note...fn6()")
        return "kim"
    }
}