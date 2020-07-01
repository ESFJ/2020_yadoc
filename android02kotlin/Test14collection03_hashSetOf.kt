package com.example.android02kotlin

fun main() {
    println("읽기 전용 set, 변경 가능한 set")

    // 1. 변경 가능한 Set : hashSetOf, mutableSetOf >>> HashSet, MutableSet

    // Set : 중복허용X, 순서X
    //val hSet:HashSet<Any?> = hashSetOf(1,2,"kim", 3, false, null, IntArray(3), arrayOf(1,2,3))
    val hSet:MutableSet<Any?> = mutableSetOf(1,1,2,2,"kim","kim","kim", 3, false, null)

    // index가 없으니 수정 개념이 아니고 삭제후 다시 입력하는 개념
    hSet.add(33)  // 추가
    hSet.add("yangSsem")  //추가
    hSet.remove(99)  // 데이터로 삭제
    for(item in hSet){
        print("$item ")
    }
    println()

    println(hSet.filterNotNull())
    println(hSet.filterIsInstance<Int>())
    println(hSet.filterIsInstance<String>())
    println(hSet.filterIsInstance<IntArray>())
    println(hSet.filterIsInstance<Array<Int>>())

    val hSet2:HashSet<Int> = hashSetOf(3,2,3,1,2,3,1,2,3,1,2,1)
    for(item in hSet2){
        print("$item ")
    }
    println()
    println("alist2.sum() : ${hSet2.sum()}")
    println("alist2.max() : ${hSet2.max()}")
    println("alist2.min() : ${hSet2.min()}")
    println("alist2.first() : ${hSet2.first()}")
    println("alist2.last() : ${hSet2.last()}")
    // hSet2.sort()  -> 순서가 없기때문에 sort도 안됨

    val hSet3 = hSet2.sorted()  // 재할당

    for(item in hSet2){
        print("$item ")
    }
    println()

    hSet3.forEach {
        print("$it ")
    }
    println()

    // char도 결국 내부로는 정수값을 쓰기때문에 range 설정 가능
    println(('a'..'z').asSequence().toList()) // 변경 불가능 List
    println(('a'..'z').asSequence().toMutableList()) // 변경가능 List
    println(('a'..'z').asSequence().toSet()) // 변경X set
    println(('a'..'z').asSequence().toMutableSet())  // 변경O set

    println('a'..'z')
    println(('a'..'z').toMutableSet())  // asSequence를 사용하지 않아도 되긴하는데 sequence 객체는 아님
    println(('a'..'z').map { it.toUpperCase() }.toMutableSet())

    val up:HashSet<Char> = ('a'..'z').map { it.toUpperCase() }.toHashSet()
    println(up)
    up.add('a')
    println(up.all { it.isUpperCase() }) // all : 전체가 내가 원하는 식에 대해 참인지 거짓인지 판별해줌 (모두 만족 : true)
    println(up.any { it.isLowerCase() }) // all : 전체가 내가 원하는 식에 대해 참인지 거짓인지 판별해줌 (하나라도 만족 : true)
    println()
    println(('a'..'z').all { it.isLowerCase() })  // 모두만족
    println(('a'..'z').any { it.isLowerCase() })  // 하나라도 만족
    println(('A'..'z').toMutableSet())
}