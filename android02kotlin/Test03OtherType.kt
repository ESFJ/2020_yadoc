
package com.example.android02kotlin

fun main() {
    println("Boolean")

    println("true : ${true}")
    println("!true : ${!true}")
    println("false : ${false}")
    println("!false : ${!false}")

    // Unit : return값이 없다 (= void)
    // Nothing : exception 발생 타입 (비정상 종료시 사용)(일부러 발생시킴)
    // Any : 최상위 타입, 모든 타입을 아우르는 타입 (= Object)
    // 코틀린은 아규먼트에 들어가는 순서가 타입명 변수명이 아니고 변수명 타입임
    // TypeName? : type이름에 물음표(?)가 붙으면 null을 허용한다는 얘기
    // (a int? 면 int타입의 a인데 a로 null이 들어올수있다는 얘기임)
    // (?가 안붙은 경우 null이 들어오면 에러남)



}