package com.example.android02kotlin

fun main() {
    println("abstract class")

    // 추상클래스의 생성자로는 객체(인스턴스) 생성 불가
    // 다형성을 이용해서 객체 생성
//    var p = Test19Person()
    var p:Test19Person = Test19Man()
    p.eat()  // Man이 재정의한 그 함수가 동작됨
    p.eat2()  // 물론 Man의 함수와 변수는 사용못함
}

abstract class Test19Person{
    val name:String = "kim"
    
    constructor(){
        
    }
    // 추상 함수는 상속받은 클래스가 반드시 오버라이딩
    abstract fun eat()  // 추상 클래스임을 명시
    fun eat2(){
        // 일반 함수도 사용가능
    }
}

// abstract가 붙으면 open을 적지 않아도 상속과 오버라이드 가능
class Test19Man:Test19Person(){
    // 반드시 재정의 OR Test19Man도 abstract로 만들기
    override fun eat() {
        println("Test19Man...eat()")
    }
    fun work(){
        println("Test19Man...work()")
    }

}