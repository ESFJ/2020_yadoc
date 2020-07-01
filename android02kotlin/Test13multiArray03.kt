package com.example.android02kotlin

fun main() {
    println("다차원 배열...")
    
    // 생성자로 만드는 방법
    val namess:Array<Array<String>> = Array(2,{Array(4,{i -> "kim$i"})})
    for(names in namess){
        for(name in names){
            print("$name ")
        }
        println()
    }

    namess.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }

    // primitive type만 받는 array
    var suss:Array<IntArray> = Array<IntArray>(2,{ intArrayOf(1,2,3)})
    println(suss.contentDeepToString())
    
    // 따로 명시를 하지않을경우 기본값(0)이 들어감
    var suss2:Array<IntArray> = Array<IntArray>(2,{ IntArray(10) })
    println(suss2.contentDeepToString())

    var suss3:Array<IntArray> = Array<IntArray>(2,{ IntArray(4,{i -> i}) })
    println(suss3.contentDeepToString())

    // [[0.0, 0.0, 0.0], [0.0, 0.0, 0.0]]
    // primitive type에만 명시안하면 기본값이 있고 object type에는 안적으면 안됨!
    var dss:Array<DoubleArray> = Array<DoubleArray>(2,{DoubleArray(3)})
    println(dss.contentDeepToString())

    // [[false, false, false], [false, false, false], [false, false, false]]
    var bss:Array<BooleanArray> = Array<BooleanArray>(3, { BooleanArray(3)})
    println(bss.contentDeepToString())

    // 따로 있는 두 배열을 하나의 배열로 합치기 (병합)(concat)
    // [false, false, false], [false, false, false] -> [false, false, false, false, false, false]
    //println(bss[0] + bss[1]) // 1차원 + 1차원 = 1차원
    var bss01 = bss[0] + bss[1]
    println(bss01.contentToString()) // 1차원 배열은 contentToString, 2차원은 contentDeepToString

    // [0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
    // dss를 1차원으로 변경 X -> 값을 복사한 새로운 1차원 배열을 만든것
    var dss01 = dss[0] + dss[1]
    println(dss01.contentToString())

    // [kim0, kim1, kim2, kim3, kim0, kim1, kim2, kim3]
    println((namess[0]!! + namess[1]!!).contentToString())
    // == {
    // var newNames = namess[0]!! + namess[1]!!
    // println(newNames.contentToString())
    // }
    var newNames = namess[0]!! + namess[1]!!
    newNames.sort()  // 오름차순으로 sort -> 반환값 없음 (원본이 바뀌는것) -> sorted 사용하면 결과를 반환
    println(newNames.contentToString())
    //newNames.reverse()  // 내림차순 sort : 원본이 정렬됨
    var reversedNewName = newNames.reversed()  // 값을 정렬 + 복사한 새 배열 반환
    println(newNames.contentToString())
    println(reversedNewName)

}