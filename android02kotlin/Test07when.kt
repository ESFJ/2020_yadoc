package com.example.android02kotlin

fun main() {
    println("when : java switch, -> : java case")

    var su:Int = 5
    when(su){
        //case 0:
        0 -> println("su : 0") //해당되는 case만 실행하고 자동으로 break됨
        1 -> println("su : 1")
        2 -> println("su : 2")
        3 -> println("su : 3")
        4,5,6 -> println("su : 4,5,6")
        else -> println("other")
    }

    var name:String = "kim3"
    var result:String = when(name){
        "kim" -> {
            //block 사용가능
            println("Hello $name")
            "Hello $name"
        }
        "kim2" -> {
            println("Hi $name")
            "Hi $name"
        }
        "kim3" -> {
            println("Bye $name")
            "Bye $name"
        }
        "kim4","kim5","kim6" -> {
            println("Everyone $name")
            "Everyone $name"
        }
        else -> {
            println("Who are you???")
            "Who are you???"
        }
    }

    //when문도 마지막 문장을 반환할수있음
    println("result : $result")
    
    println("when문에 in .. 연산 사용가능")
    //범위 지정을 편하게 하기 위함~!
    var point:Int = 88
    var grade:String = when(point){
        //90,91,92,93,94,95,96,97,98,99,100 -> "A"  //비효율적!!!
        //80,81,82,83,84,85,86,87,88,89 -> "B"  //비효율적!!!
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in arrayOf(1,2,3)-> "부모님 모셔와"  //배열과도 사용가능
        else -> "F"
    }

    println("grade : $grade")

    var kor:Int = 90
    when(kor){
        "90".toInt() -> println(kor)
        else -> println("other")
    }

    println("when()가 없어도 되는 경우가 있다!")
    when{
        //if문처럼 쓰이는 경우
        //참거짓에 대한게 오는 경우
        true -> println("true")
        false -> println("false")
        else -> println("else")
    }

    var x:Int = 2
    when{
        //참거짓의 결과가 있을때는 when문에 ()가 사라져도 괜찮음
        x >= 3 -> println("x >= 3")
        x < 0 -> println("x < 0")
        else -> println("else")
    }

    when{
        isOdd(x) -> println("x is odd") // 함수의 결과값이 나와도 됨
        isEven(x) -> println("x is even")
        x > 0 -> println("x < 0")  //위에서 먼저 맞는 결과가 있으면 아래를 확인하지 않음
        else -> println("else")
    }

    println(" is !is ")
    var eng:Int = 88
    when(eng){
        //사실 타입이 안맞으면 처음부터 안되긴 함..
        is Int -> println("Int Type")
        !is Int -> println("Not Int Type")
    }

} //end main()

fun isOdd(x:Int):Boolean{
    if(x % 2 != 0) return true
    else return false
}

fun isEven(x:Int):Boolean{
    if(x % 2 == 0) return true
    else return false
}