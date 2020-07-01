package com.example.android02kotlin

import kotlin.random.Random

fun main() {
    println("읽기 전용 목록, 변경 가능한 목록")
    //  2. 읽기 전용 목록 : ListOf >>> List
    // val때문이 아니라 List때문에 읽기전용이 됨
    val alist:List<Any?> = listOf(1,2,"kim", 3, false, null, IntArray(3), arrayOf(1,2,3))

    for(item in alist){
        print("$item ")
    }
    println()

    println(alist.filterNotNull())
    println(alist.filterIsInstance<Int>())
    println(alist.filterIsInstance<String>())
    println(alist.filterIsInstance<IntArray>())
    println(alist.filterIsInstance<Array<Int>>())

    val alist2:List<Int> = listOf(1,2,3,1,2,3,1,2,3,1,2,3) // 정수로만 이루어진 list를 받겠습니다.
    for(item in alist2){
        print("$item ")
    }
    println()
    println("alist2.sum() : ${alist2.sum()}")
    println("alist2.max() : ${alist2.max()}")
    println("alist2.min() : ${alist2.min()}")
    println("alist2.first() : ${alist2.first()}")
    println("alist2.last() : ${alist2.last()}")

    // 원본 변경 X -> 복사값만 저장가능
    val new_alist2 = alist2.sorted()
    for(item in new_alist2){
        print("$item ")
    }
    println()

    new_alist2.forEach {
        print("$it ")
    }
    println()

    val alist3:List<Double> = listOf(1.1, 2.2 ,3.3) // 정수로만 이루어진 list를 받겠습니다.
    for(item in alist3){
        print("$item ")
    }
    println()

    //var alist4 = listOf(1,2,3)  // 타입 명시 안해줘도 알아서 추론해서 들어감
    var alist4:List<Int> = listOf(1,2,3)  // 정확하게 넣고싶은 type이 있는 경우 명시해주어야함
    println(alist4)

    // 원본이 읽기전용이어도 복제한 배열에 데이터 추가하는 함수 사용 가능
    var new_alist4 = alist4.plus(44)  // alist4에 44를 추가해줘 + 그리고 그 배열을 반환해줘 (복제품, 원본에 영향X)
    println(new_alist4)
    
    // plus도 반환 타입이 List라서 새로 만들어진 경우에도 추가는 불가능함
    //new_alist4.add(100)  // 추가 수정은 안됨

    // += 가 plus랑 같은거라서 alist가 var인 경우는 += 가능
    alist4 += 88  // 연산자 오버로딩은 var일때 가능
    println(alist4)

    val alist5 = listOf<Int>(1,2,3,4,5)
    println(alist5)
    println(alist5.toIntArray())  // collection -> intArray

    val arr:IntArray = alist5.toIntArray()
    println(arr.contentToString())
    arr[0] = 100
    println(arr.contentToString())
    println(arr.toList())  // 윗줄과 같지만 위는 IntArray, 여기는 List
    val newList:List<Int> = arr.toList()
    //newList = 99  // 수정 불가

    // sequence 형태.
    println(sequenceOf(1,2,3,4,5,6))
    println(sequenceOf(1,2,3,4,5,6).toList())  // 수정불가 리스트
    println(sequenceOf(1,2,3,4,5,6).toMutableList())  // 수정가능 리스트

    // 수정 불가
    val seqList:List<Int> = sequenceOf(1,2,3,4,5,6).toList()
    println(seqList)

    // 수정 가능 (삽입, 삭제, 변경)
    val seqMutList:MutableList<Int> = sequenceOf(1,2,3,4,5,6).toMutableList()
    seqMutList.add(7)
    seqMutList.add(7)
    println(seqMutList)

    // range(범위연산)를 이용한 asSequence
    val seqList2:List<Int> = (1..10).asSequence().toList()  // 시퀀스 부여하듯 list를 만듬
    println(seqList2)
    println((1..10).asSequence().filter {
        // forEach처럼 it를 이용해 필터링 가능
        it % 2 == 0  // 짝수만 필터링해서 배열로 만들어줌
    }.toList())

    // filtering -> mapping
    println((1..10).asSequence().filter {it % 2 == 0}.map {it * 10}.toList())

    // lamdba 형식의 generate  // seed, lamdba
    println(generateSequence(0, {it}))  // sequence
    println(generateSequence(0, {it}).take(10).toList()) // n개 가져오기
    println(generateSequence(0,{it+1}).take(10).toList())
    println(generateSequence(10, {it+2}).take(10).toList())

    val newList2 = listOf<Int>(1,2,3,4,5,6)
    println(newList2.filter{it % 2 == 0})
    println(newList2.map{it * 10})

    // 구분자를 넣어 안에있는 요소들을 합쳐 문자로 반환
    println(newList.joinToString("-", "[" , "]"))
    println(newList.joinToString("-", "[" , "]", 3))
    
    // list:List<Int> = null(X)[null(X)]: list도 null일수없고, 요소도 null이 안됨 
    // list:List<Int?>? = null(O)[null(O)]: list도 null허용, 요소도 null 허용 
    // list:List<Int>? = null(O)[null(X)]: list도 null허용, 요소는 null 안됨
    // list:List<Int?> = null(X)[null(O)]: list도 null일수없고, 요소는 null 허용

    // array를 만드는 방법
    val arr2:Array<Int> = arrayOf(1,2,3)
    val arr3:Array<Int> = Array(4, {i -> i})

    val lst:List<Int> = listOf(1,2,3)
    val lst2:List<Int> = List(4, {i -> i})
    //val lst3:List<Int> = List(6, {Random.nextInt(5)})  // 값을 하나만 주면 끝값만
    val lst3:List<Int> = List(6, {Random.nextInt(1, 46)})  // 값 두개를 주면 시작, 끝
    println(lst3)

}