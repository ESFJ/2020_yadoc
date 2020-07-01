package com.example.android02kotlin

fun main() {
    println("읽기 전용 목록, 변경 가능한 목록")

    // 1. 변경 가능한 List : arrayListOf >>> ArrayList, MutableList

    // null을 포함한 모든 타입 : Any? (null 미포함 : Any)
    val alist:ArrayList<Any?> = arrayListOf(1,2,"kim", 3, false, null, IntArray(3), arrayOf(1,2,3))
    // 앞에서 명시해주면 뒤에서는 type 생략가능
    // val alist:MutableList<Any?> = mutableListOf(1,2,"kim", 3, false, null) // 앞에서 명시해주면 뒤에서는 type 생략가능

    alist[0] = 100  // 수정
    alist.set(1, 99) // 수정
    alist.add(33)  // 추가
    alist.add("yangSsem")  //추가
    alist.remove(99)  // 데이터로 삭제
    alist.removeAt(0) // index로 삭제
    for(item in alist){
        print("$item ")
    }
    println()

    println(alist.filterNotNull())
    println(alist.filterIsInstance<Int>())
    println(alist.filterIsInstance<String>())
    println(alist.filterIsInstance<IntArray>())
    println(alist.filterIsInstance<Array<Int>>())

    val alist2:ArrayList<Int> = arrayListOf(1,2,3,1,2,3,1,2,3,1,2,3) // 정수로만 이루어진 list를 받겠습니다.
    for(item in alist2){
        print("$item ")
    }
    println()
    println("alist2.sum() : ${alist2.sum()}")
    println("alist2.max() : ${alist2.max()}")
    println("alist2.min() : ${alist2.min()}")
    println("alist2.first() : ${alist2.first()}")
    println("alist2.last() : ${alist2.last()}")
    alist2.sort()
    for(item in alist2){
        print("$item ")
    }
    println()

    alist2.forEach {
        print("$it ")
    }
    println()

    val alist3:ArrayList<Double> = arrayListOf(1.1, 2.2 ,3.3) // 정수로만 이루어진 list를 받겠습니다.
    for(item in alist3){
        print("$item ")
    }
    println()

    val alist4:ArrayList<Int> = arrayListOf(1,2,3,1,2,3,1,2,3,1,2,3)
    println(alist4)
    println(alist4.toIntArray())
    val arr:IntArray = alist4.toIntArray()
    println(arr.contentToString())
    val newList:MutableList<Int> = arr.toMutableList()

    // alist4 --IntArray--> arr --mutableList(arrayList)--> newList
}