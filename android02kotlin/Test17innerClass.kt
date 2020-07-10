package com.example.android02kotlin

fun main() {
    println("inner class")
    // 클래스의 정의는 클래스 내부에도 정의할 수 있다.
    // 단, 내부 클래스의 기능(외부 클래스 자원 참조)을 사용하고 싶다면
    // inner class 선언이 필수

    //var out:Outer = Outer()
    var out = Outer()
    println(out.name)
    out.fn()

    // inner class 호출
    //var inn:Outer.Inner = out.Inner()
    var inn = out.Inner()
    inn.test()

    // 함수안에 함수를 정의할수있듯이 함수안에 클래스를 정의할 수 있다.
    // 이를 로컬내부클래스라 한다.
    // 함수의 로컬 변수를 참조할 수 있다.
    //val kor = 100
    var kor = 100
    class LocalOuter{
        var name:String = "Yang"
        fun fn(){
            println("Local Outer... fn()")
            kor = 99 // 값 변경도 가능
            println("kor : $kor")
        }
        inner class AAA{
            // 로컬 내부 클래스에서도 이너 클래스 가능
        }
    }
    var localOut = LocalOuter()
    println("localOut.... : ${localOut.name}")
    localOut.fn()

}

class Outer{
    var name:String = "kim"
    fun fn(){
        println("outer class fn()...")
    }
    //class Inner{
    inner class Inner{  // inner class임을 명시해야 outer쪽의 변수와 함수를 사용 가능
        // class안에 class가 들어간 경우
        // Outer클래스의 자원을 객체 생성하지 않고도
        // inner class라고 선언시 사용할수있다.
        var age:Int = 33
        fun test(){
            println("inner class test()")
            println("age:$age")
            println("name:$name") // 그냥은 접근 안됨 -> inner class임을 명시해줘야함
            println(fn())
        }
    }
}