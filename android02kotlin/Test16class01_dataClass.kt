package com.example.android02kotlin

fun main(){
    println("data class")

    // data class : equals(), hashCode(), toString() -> auto overriding
    var pvo:PersonVO = PersonVO() // 객체 생성
    println(pvo)
    pvo.name = "Yang"
    println(pvo.name)
    println(pvo.age)

    pvo = PersonVO("lee", 44)
    println(pvo)
    println(pvo.name)
    println(pvo.age)

}

// 모든 파라미터는 val or var로 선언해야함
// person과 관련된 값들을 가진 객체
//data class PersonVO(var name:String, var age:Int)

// 디폴트값을 부여할수있다.
data class PersonVO(var name:String="kim", var age:Int=33)

// 생성자의 파라미터는 최소 한개이상
//data class PersonVO()  // 데이터를 저장하는 객체인데 데이터를 하나도 넣을수없다! -> error!(이런거 필요없어!)

//data class PersonVO(){
//    var name:String = ""
//    var age:Int = 33
//}
