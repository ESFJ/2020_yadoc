package com.example.android02kotlin

fun main() {
    println("while--------------2")

    // 정규 표현식

    val regex:Regex = "((\\d+)|-(\\d+))".toRegex() // regular expression
    //val regex:Regex = "(\\w+)".toRegex()
    //val regex:Regex = "(\\w+) || -(\\w+)".toRegex()
    // 양의정수 or 음의정수
    // 내가 쓴 패턴이 정규 표현식이 됨
    println(regex.matches(""))
    println(regex.matches("1"))
    println(regex.matches("2"))
    println(regex.matches("-1"))
    println(regex.matches("-2")) // 양/음의 정수라서 true
    println(regex.matches("kim"))

    var strNum:String? = ""
    while(true){
        println("Input number[종료시-1]: ")
        strNum = readLine()
        var num = if(regex.matches(strNum.toString())){
            //strNum.toString().toInt()
            strNum!!.toInt()  // 이미 선언된 변수에 null을 허용하지 않음을 선언
        } else{
            println("잘못입력")
            999
        }
        println("num:$num")
        if(num == -1) break
    }

}