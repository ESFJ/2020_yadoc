package com.example.android02kotlin

fun main() {
    println("create class3")

    val score = Test16Score(1, "kim", 11, 22, 33)
    println(score)
    score.num = 2
    score.name = "lee"
    score.kor = 44
    score.eng = 55
    score.math = 66
    println("total : ${score.total()}")
    score.printAll()
    println(score)

    println(score.sum)
    // score.sum = 133  // get함수를 이용해 값을 가져오기때문에 직접 바꾸는거 안됨

    val score2 = Test16ScoreData(5, "Yang", 77, 77, 77)
    println(score2)
    score2.num = 22
    score2.name = "Yang2"
    score2.kor = 22
    score2.eng = 22
    score2.math = 22
    println(score2)
    println(score2.sum)

    println(score2.hashCode())
}

// 데이터 클래스에도 sum값을 정확히 받고 싶다면,
// 블럭을 만들고 sum에 대한 getter를 생성해줘야한다.
data class Test16ScoreData(
    var num:Int, var name:String,
    var kor:Int, var eng:Int, var math:Int/*, val sum:Int = kor+eng+math*/){
    val sum:Int get() = kor+eng+math
    override fun toString(): String {
        return "Test16ScoreData(num=$num, name='$name', kor=$kor, eng=$eng, math=$math, sum=${kor+eng+math})"
    }
}



//Test16Score 클래스를 정의하시오
// 속성(프로퍼티) : 번호num, 이름name, 국어kor, 영어eng, 수학math
// 기능(함수) : 총점반환total, 모든 속성 출력하기ㅔptintAll
class Test16Score(var num:Int, var name:String, var kor:Int, var eng:Int, var math:Int){
    fun total() = kor + eng + math

    //var sum:Int = kor+eng+math  // 변수는 제일 처음 넣어준 값으로 고정 -> 함수형태로 받게해야함
    // 국영우 세터에 의한 변경된 값의 합을 가져오고자 하면
    // sum을 읽기 전용(getter)으로 생성해줘야한다.
    val sum:Int get() = kor+eng+math // 프로퍼티는 프로퍼티인데 최신값에대한 합계를 가져옴( total과 같은 방식)

    fun printAll() = println("num : $num, name : $name, kor : $kor, eng : $eng, math : $math")

    // 마우스 우클릭 -> generate -> toString
    override fun toString(): String {
        return "Test16Score(num=$num, name='$name', kor=$kor, eng=$eng, math=$math)"
    }
}