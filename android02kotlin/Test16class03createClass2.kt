package com.example.android02kotlin

import com.example.android02kotlin.aaa.Test16AAA

fun main() {
    println("create class2")
    // 일반 class
    // 모든 클래스는 동일 패키지에서 유니크
    // Kotlin은 OOP(객체 지향 프로그래밍), FP(functional programming) 모두
    // 캡슐화, 상속, 다형성 등등 지원

    //val p = Tesst16Person2()
    // 생성자에서 프로퍼티의 기본값 초기화를 생략시는
    // 객체 생성할때 인자값이 필수
    //val p = Tesst16Person2("kim", 33)
    
    // 원하는 프로퍼티 초기값 설정 가능
    val p = Tesst16Person2(age = 33) 
    p.name = "Yang"
    p.age = 29
    //p.tel = "02"  // tel은 읽기전용이므로 직접 변경 불가
    p.setTel = "02"
    println(p.name)
    println(p.age)
    println(p.tel)
    println(p.setTel)
    println(p.total)
    p.sleep()
    p.sleep2()
    p.sleep3() // sleep3은 fun(함수)이 아니고 var(변수)로 할당했기때문에 변수색으로 에디팅
    println(p.getColor())
    println(p.getColor2())
    println(p.getcolor3())

}

class Tesst16Person2 constructor(
                        var name:String = "lee",
                        var age:Int,
                        val tel:String  = "010"){
    // 클래스의 전역변수 : 속성, 멤버 필드
    // var(getters, setters), val(getters) 둘다 가능

    // 초기화 블럭
    // 객체가 처음 생성후 실행됨
    init {
        age = 88
        println("init{}...")
    }
    fun sleep():Unit{
        println("sleep().....")
    }

    val total:String get() = "$name, $age"

    // tel은 val이라서 변경 불가 하므로 다르 속성으로 생성
    var setTel:String = ""
        set(value) {  //setter는 이런 모양새이다
            field = value
        }

    fun sleep2() = println("sleep2()...")

    var sleep3 = {println("sleep3()...")}

    fun getColor():Int{
        return 111
    }

    fun getColor2() = 256
    var getcolor3 = {0}
}