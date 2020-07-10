package com.example.android02kotlin

fun main() {
    println("open class")
    // kotlin의 기본클래스는 상속을 허용하지 않습니다!

    var p:Test18Person = Test18Person()
    println(p.name)
    p.eat()

    var m = Test18Man()
    println(m.name)
    println(m.tel)
    m.work()
    m.eat()

    // 다형성 : 상속이 전제로 된 경우 슈퍼클래스 타입 객체 생성시 서브 클래스 생성자로 객체 생성 가능(업캐스팅)
    // 대신, 접근할수있는 자원은 슈퍼 클래스 본인것만 가능
     var p2:Test18Person = Test18Woman()
    println(p2.name)
//    println(p2.tel) // Person type이기때문에 Man의 자원에 접근이 불가능
//    p2.work()  // Test18Man의 자원은 접근 불가
    p2.eat()
}

// open : 다른 클래스에서 상속을 허용한다
open class Test18Person{
    val name:String = "kim"
    fun eat() {
        println("Test18Person... eat()")
    }
}

class Test18Woman : Test18Person(){
    val tel:String = "02"
    fun work(){
        println("Test18Woman...work()")
        println("name:$name")
        eat()
    }
}
class Test18Man : Test18Person(){
    val tel:String = "010"
    fun work(){
        println("Test18Man...work()")
        println("name:$name")  // Test18Person의 자원을 자기것처럼 씀
        eat()
    }
}