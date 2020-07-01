package com.example.android02kotlin

fun main(){
    println("data class")
    var car1:Car = Car("sonata", 99999)
    println(car1)

//    car1.name = "HR"  // val은 final이라서 수정 불가능
    println(car1.name)
    println(car1.price)

    var car2:Car = Car("BMW", 30000000)
    println(car2)

}
// 자동차 데이터 클래스
// 속성 : 차 이름, 가격
// 객체 생성 및 출력(출력시 데이터는 임의의값)

data class Car(val name:String, val price:Int)