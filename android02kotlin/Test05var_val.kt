package com.example.android02kotlin

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    println("var         val======================")

    //지역변수 (함수 내부에 선언된 변수)
    // var 선언된 동일한 변수명 사용 불가

    var su = 100
    //var su = 100 -> error!
    su = 222
    println("su : ${su}")

    var su2:Int // 할당할때는 할당하는 값이 있으니까 타입 지정이 필요없는데 선언만 할때는 타입이 필수
    su2 = 200
    su2 = 333 //변수니까 물론 중간에 값 바꾸기 ㄱㄴㄱㄴ
    //var su2:Int = 200 -> 이거는 선언과 동시에 할당하는 경우

    println("su2 : ${su2}")
    // su가 연산 필요없이 단독으로 사용 될때는 $su 이렇게도 가능
    // 변수에 연산이 필요할때는 {} 필수
    println("su : $su")
    println("su + su2 : ${su + su2}")

    println("==========================")
    println("val : java final : read only") // 상수 //read only //한번 세팅하면 값을 바꿀수없음~!
    val a = 10
    println("a : $a")
    //a = 20 -> a가 상수이기때문에 값 변경 -> error!

    //val c:Int
    //println("c : $c") final은 초기화 하지않고는 사용할수없음! ->  error!

    val b:Int
    b = 333 // 반드시 초기화 후 사용!!

    // 동일파일의 const 상수 접근
    println(RESULT_CODE_ZERO)
    println(RESULT_CODE_PI)

    // 다른 패키지에 있을때는 패키지 풀네임 명시
    // 예 : println(com.example.android02kotlin.RESULT_CODE_PI)

    var name:String = "kim"
    name = "lee" //변수니까 값 변경 가능
    println("name : $name")
    
    var toDay:Date = Date() //java util의 date 그대로 사용 //kotlin은 new연산자 안씀
    println("toDay : $toDay")
    println("toDay : ${toDay.time}")
    println("System.currentTimeMillis() : ${System.currentTimeMillis()}")
    //simple date format도 사용 가능 (다 똑같은데 new만 안쓴다고 생각하면 편함)
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(toDay))

}

// 함수밖에서 선언된 변수(const 사용)
// 함수 내에서도 사용가능
//const == public static final
const val RESULT_CODE_ZERO:Int = 0 // const는 var가 안됨 //처음 0으로 시작해서 끝날때까지 0으로 사용될때 사용
const val RESULT_CODE_PI:Double = 3.14