package com.example.android02kotlin

import com.example.android02kotlin.aaa.Test16AAA

fun main() {
    println("create class")
    // 일반 class
    // 모든 클래스는 동일 패키지에서 유니크
    // Kotlin은 OOP(객체 지향 프로그래밍), FP(functional programming) 모두
    // 캡슐화, 상속, 다형성 등등 지원

    //val p = Tesst16Person()
    val p = Test16AAA()
    p.name = "Yang"
    p.age = 29
    println(p.name)
    println(p.age)
    p.sleep()
    p.sleep2()
    p.sleep3() // sleep3은 fun(함수)이 아니고 var(변수)로 할당했기때문에 변수색으로 에디팅
    println(p.getColor())
    println(p.getColor2())
    println(p.getcolor3())

}

// 패키지내 유니크한 클래스 -> 가능
// 클래스 접근제한자 생략되어있으면 public
// 생성자 또한 명시가 없으면 public + 기본 생성자는 생략 가능
// 생성자의 파라미터는 클래스의 프로퍼티의 선언 및 초기화 목적
class Tesst16Person /*constructor()*/{
    // 클래스의 전역변수 : 속성, 멤버 필드
    // var(getters, setters), val(getters) 둘다 가능
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

// 패키지내 이미 있는 클래스이름 -> 불가능
//class Test16AAA{
//
//}