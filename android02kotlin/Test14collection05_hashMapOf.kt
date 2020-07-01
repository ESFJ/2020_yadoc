package com.example.android02kotlin

import kotlin.random.Random


fun main() {
    println("읽기 전용 map, 변경 가능한 map")
    // Key 중복 허용 안함(덮어씀), value는 중복가능. 순서가 없다.
    // 1. 변경 가능한 map : hashMapOf, mutableMapOf >>> HashMap, MutableMap

    // <Key Type, Value Type>
    val map:MutableMap<Any, Any?> = mutableMapOf("key1" to "kim", "key2" to 100, "key3" to 100, 1 to 111, 2 to null)
    println("map.size : ${map.size}")
    println("map.keys : ${map.keys}") // key값들을 전부 출력 // key는 set에 저장되는 느낌이라고 생각하면 편함
    println("map.values : ${map.values}") // value를 전부 출력
    println("map.get : ${map.get("key1")}")
    println("map.get : ${map.get("key2")}")
    println("map.get : ${map.get(1)}") // index X, 1이라는 key가 있으면 값을 가져와라
    println("map.get : ${map.get(2)}")

    // Key to Value 추가
    // K-V를 사용하는 경우는 대부분 put~ 함수를 사용
    map.put("key4", Array(4, {i -> i}))

    // 수정
    // replace 사용 -> version24 부터 사용가능
    // key가 같은 값이 들어올 경우 덮어써지기때문에 put으로 수정도 가능함
    map.put("key1", "yangSsem")

    // 삭제
    // remove -> key는 유일하기때문에 key로 바로 삭제 가능
    map.remove("key3")

    for(key in map.keys){
        // key값을 아는건 map.keys
        print("${map.get(key)} ")
    }
    println()

    for(param in map){
        println("${param.key} : ${param.value}")
    }
    println()

    //  filter
    println(map.filter { it != null }) // it == key
    println(map.filter { it == null })

    // filterValues
    println(map.filterValues { it != null }) // except null value
    println(map.filterValues { it is String })
    println(map.filterValues { it is Array<*> })
    println(map.filterValues { it is IntArray }) // 해당하는 값이 없을경우 빈 상태로 출력됨
    println(map.filterValues { it is Int })

    // mapValues
    println(map.mapValues{ it.value.toString() + "%%"})  // map안의 parameter가 it로 들어감
    println(map.mapValues{
        if(it.value is String) it.value.toString()+ " hello"
        else if(it.value is Int) it.value.toString()+ "%"
        else it.value
    })

    // Pair<Key, Value> 객체 사용하여 맵핑
    val p1 = Pair<String, String>("name1", "Yang1")
    val p2 = Pair<String, String>("name2", "Yang2")
    val p3 = Pair<String, String>("name3", "Yang3")
    val p4 = Pair<String, String>("name4", "Yang4")

    var pMap:Map<String, String> = hashMapOf(p1, p2, "name5" to "Yang5")
    pMap = pMap.plus(p3)
    pMap = pMap.plus(p4)
    println(pMap)

}