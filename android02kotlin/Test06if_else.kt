package com.example.android02kotlin

fun main() {
    println("if ~~ else if ~~ else")

    println(if(true) "kim" else "lee")
    // 코틀린의 if문은 실행 + 가장 끝줄의 값을 리턴함!!

    var point:Int = 90
    println(if(point >= 90) "A" else if(point>=80) "B" else "C")

    var result:String? = null
    result = if(point >= 90) "A" else if(point>=80) "B" else "C"
    // 사실 이 경우는 굳이 null을 넣어주지않고 선언만 해놔도 괜찮음
    // 하지만 어떤 값이 들어올지 모르는 경우 null값을 허용하고 null을 할당해주는게 좋음
    println("result %s".format(result)) // 이런 방식으로도 가능하지만 $사용이 편함

    //95점 이상이면 A+, 그렇지않으면 A0, 85점이상이면 B+, 그렇지않으면 B0
    //이런 식으로 성적처리가 되도록 분기문을 추가해보세요.

//    result = if(point>=95) "A+"
//            else if(point>=90) "A0"
//            else if(point>=85) "B+"
//            else "B0"
//
//    println(result)

    // C의 경우 +0를 안붙이기때문에 C이하를 제외해줘야함
    if(point >= 80) {
        if (point % 10 >= 5) result += "+"
        else result += "0"
    }
    println(result)

    var su:Int = 2
    su *=
        if(su == 1){
            println("10 * $su")
            10  // 맨 마지막 줄의 값이 반환됨
        }else if(su == 2){
            println("100 * $su")
            100
        }else if(su == 3){
            println("1000 * $su")
            1000
        }else{
            println("0 * $su")
            0
        }
    println("su : $su")
    
    println("조건문에 is : Type체크")
    if(su is Int) println("Int")
    else println("not Int")

    if(result is String) println("String")
    else println("not String")

}