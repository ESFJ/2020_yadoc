package com.example.android02kotlin

fun main() {
    println("open class... open fun... open property")
    // kotlin의 기본클래스는 상속을 허용하지 않습니다!
    // 속성과 기능도 재정의 허용하지 않습니다.
    var p:Test18Person2 = Test18Person2()
    println(p.name)
    println(p.name2)
    p.eat()
    p.sleep()

    println("----m----")
    var m = Test18Man2()
    println(m.name)  // p의 name을 그대로 씀
    println(m.name2)  // p의 name2를 오버라이드
    m.sleep()

    println("---다형성---")
    var p2:Test18Person2 = Test18Man2()  // Person타입이지만 자식의 생성자로 생성함
    println(p2.name2)  // Man이 재정의한 자원을 쓰게됨
    p2.sleep()

}

// open : 다른 클래스에서 상속을 허용한다
open class Test18Person2{
    val name:String = "kim"
    open val name2:String = "kim2"
    fun eat() {
        println("Test18Person2... eat()")
    }

    open fun sleep(){  // open : override 허용
        println("Test18Person2... sleep()")
    }
}

class Test18Man2 : Test18Person2(){
    override val name2:String = "Yang2"
    val tel:String = "010"
    fun work(){
        println("Test18Man2...work()")
        println("Test18Man2...name:$name")  // Test18Person의 자원을 자기것처럼 씀
        eat()
    }

    override fun sleep(){  // override : 함수 재정의
        println("Test18Man2... sleep()")
    }


}