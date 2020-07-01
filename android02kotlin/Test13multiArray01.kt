package com.example.android02kotlin

import java.util.*

fun main() {
    println("다차원 배열...")
    // [[1,2,3], [11,22,33]]
    // 배열안에 배열이 있는 경우               // suss = { sus1{ su1, su2, su3}, sus2{su11, su22, su33} }
    var sus1:Array<Int> = arrayOf(1,2,3)
    var sus2:Array<Int> = arrayOf(11,22,33)
    //var suss:Array<Array<Int>> = arrayOf(sus1, sus2) // 배열을 인자로 가지는 배열

    var suss:Array<Array<Int>>
            = arrayOf(arrayOf(1,2,3), arrayOf(11,22,33))

    // 1 2 3
    // 11 22 33
    for(items in suss){  // sus in suss
        for(item in items){  // su in sus
            print("$item ")
        }
        println()
    }

//    suss.forEach {
//        it.forEach {  // 이쪽의 it은 suss의 it
//            print("$it ")  // 여기의 it은 sus(it)의 it
//        }
//        println()
//    }  //가장 안쪽에 들어가는게 뭔지 생각해야함

    println(Arrays.deepToString(suss))

    // Array 생성자로 2차원 배열 데이터 생성하기
    // [[0,1,2,3],[0,1,2,3]]
    val suss2:Array<Array<Int>> = Array(2, {Array(4,{i -> i})})
    for(items in suss2){  // sus in suss
        for(item in items){  // su in sus
            print("$item ")
        }
        println()
    }
    println(Arrays.deepToString(suss2))
}