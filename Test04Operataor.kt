package com.example.android02kotlin

fun main():Unit {
    println("산술 연산자")
    println(10/3)
    println(10.0/3)
    println(10/3.0)

    println("산술 연산 함수")
    println(10.plus(3)) // 10 + 3
    println(10.minus(3)) // 10 - 3
    println(10.times(3)) // 10 * 3
    println(10.div(3)) // 10 / 3
    println(10.0.div(3)) // 10.0 / 3
    println(10.rem(3)) // 10 % 3

    println("bit 연산자")
    println(8 and 3) // 8 & 3 : &같은 연산이 안되고 and, or로 해야함
    println(8 or 3) // 8 | 3
    println(8 xor 3) // 8 ^ 3
    println(8 shl 1) // 8 >> 1 = 16
    println(8 shr 1) // 8 << 1 = 4
    println(8 ushr 1) // 8 >>> 1 : unsigned bit연산
    println(8.inv()) // ~8 : bit반전연산 (대부분 +1에 마이너스한 값) : -9 // 단항연산자

    println("비교 연산자")
    println(5==5) // 동일타입 + 동일값일때 참
    //println(5==5.5) // 동일타입만 비교
    println(5===5) //주소가 다르면 거짓
    println(5!=5)
    println(5>=5)
    println(5<=5)
    println(5>5)
    println(5<5)
    println("kim" == "kim")
    println(String() == "") //String() 은 빈문자를 반환
    println(String() == null) // null은 주소가 없다는 얘기라서 아님
    
    println("문자열 비교 연산 함수================")
    println(String().equals(""))
    println("kim".equals("kim"))
    println("kim".equals("KIM", true)) // 대소문자 구분X
    println("kim".equals("KIM", false)) // 대소문자 구분X

    println("kim".compareTo("kim")) //해시코드가 같은지 비교 -> 연산해서 -를 해서
    println("kim".compareTo("Kim")) // 둘을 -를 해서 같으면 0 다르면 음,양수
    println("Kim".compareTo("kim")) // 둘을 -를 해서 같으면 0 다르면 음,양수
    println("kim".compareTo("Kim", true)) //대소문자 무시

    println("논리연산 또는 함수==================")
    println(true and true) // java & -> 둘다 참일때만 참
    println(false and true) // false 확인 -> true 확인 -> 둘다 참인지 확인해야하는 상황이면 and를 써야함
    println(true && true) // java &&
    println(false && true) // false 인거 확인후 바로 끝 -> 결과만 중요하게 생각하면 &&

    // and, or는 결과가 바로 나오는 경우에도 뒷 조건을 확인
    // &&, ||는 결과가 확인되는 순간 뒷 조건은 확인하지 않음
    println(true or false) // java | -> 둘중 하나만 참이면 참
    println(true || false)

    println("in 연산자 + range연산(..) ======= or연산이 많을때")
    // 특정 연산이 상당히 많을때
    println((3==1) or (3==2) or (3==3) or (3==4)) // 3이 1,2,3,4중에 있니???
    println(1..4) // 1~4까지 범위의 값을 갖는다
    println(3 in 1..3) // .. : range연산자
    println(3 in 1..10)
    println(-3 in 1..10)
    println(-3 !in 1..10)
    println(3 in arrayOf(1,2,3)) // 1,2,3값을 가진 배열

    println("type 체크연산자 is !is")
    println(3 is Int)
    println(3.12 is Double)
    println(3.12f is Float)
    println(true is Boolean)
    println("kim" is String)
    println("100" is String)
    println(100.toString() is String)
    println(100.toString() !is String) // -> String타입이 맞기때문에 false

    println("증감연산자.... ++, --")
    var count = 10 //var count:Int = 10 (어차피 정수의 기본단위는 int라서 생략가능)
    println("count : " + count++) // +연산후 ++이 됨 -> 출력된 후 증가
    println("count : " + count++) //
    println("count : " + count++)
    println("count :  + ${count++}") // 위랑 같음
    println("count :  + ${count++}")
    println("count :  + ${count++}")

    var count2 = 20
    println("count : " + ++count2) // ++연산후 +이 됨 -> 증가된 후 출력
    println("count : " + ++count2)
    println("count : " + ++count2)
    println("count :  + ${++count2}")
    println("count :  + ${++count2}")

    println("대입연산 또는 복합대입연산")
    var sum = 0
    sum = sum + 1
    sum = sum + 1
    sum = sum + 1
    println("sum : ${sum}") // 이건 기본 연산 방법

    sum += 1
    sum += 1
    sum += 1
    println("sum : ${sum}")

    // and, or, xor 등은 복합대입안되고 일반 대입사용할것.
    sum = sum and 10
    sum = sum or  10
    sum = sum xor 10
    sum = sum shl 2
    
    println("코틀린에서는 삼항연산이 사라짐!!!")
    // if else문으로 대체됨
    // 조건 ? 참일때 리턴값 : 거짓일때 리턴값
    // if (조건) { 실행문 } else if () { 실행문 } else { 실행문 }
    // 코틀린은 if (조건) { 리턴 } else if () { 리턴 } else { 리턴 }

    println(if(true) "kim" else "lee") // 실행뿐아니고 반환까지 함!!! -> 변수에 할당도 가능
    var x = if(false) "kim" else "lee"
    println(x) // 삼항연산자처럼 값이 반환되어 바로 x로 값이 들어옴

    var point = 80
    println(if(point >= 90) "A" else if(point >= 80) "B" else "C")

    println("객체 형변환 as")
    var obj:Any = "hello" // "hello"값이 들어간 any타입의 obj
    // (String)obj // casting
    var s1 : String = obj as String
    println(s1)
    println(s1 is String)
    println(obj === s1) // obj와 s1의 주소가 같음




}