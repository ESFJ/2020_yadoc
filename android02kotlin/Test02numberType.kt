package com.example.android02kotlin

fun main() {
    println("정수형 타입")

    // type     bit
    //--------------
//    Double      64
//    Float       32
//    Long        64
//    Int         32    //자바의 기본 타입은 int지만 코틀린은 wrapper class가 기본
//    unsigned int          // char를 제외한 나머지는 전부 unsigned가 존재!
//    Char        16
//    Short       16
//    Byte        8

    println("${Double.MIN_VALUE} ~ ${Double.MAX_VALUE}")
    println("${Float.MIN_VALUE} ~ ${Float.MAX_VALUE}")
    println("${Long.MIN_VALUE} ~ ${Long.MAX_VALUE}")
    println("${Int.MIN_VALUE} ~ ${Int.MAX_VALUE}")
    println("${Char.MIN_VALUE} ~ ${Char.MAX_VALUE}")
    println("${Short.MIN_VALUE} ~ ${Short.MAX_VALUE}")
    println("${Byte.MIN_VALUE} ~ ${Byte.MAX_VALUE}")

    println("ULong, UInt, UByte ================") //unsigned int //음수가 없는 int
    println("${ULong.MIN_VALUE} ~ ${ULong.MAX_VALUE}")
    println("${UInt.MIN_VALUE} ~ ${UInt.MAX_VALUE}")
    println("${UByte.MIN_VALUE} ~ ${UByte.MAX_VALUE}")

    println("128.toByte() : ${128.toByte()}")
    println("128.toUByte() : ${128.toUByte()}")
    //println("-128.toByte() : ${-128.toUByte()}") //-> Error!

    println("==============2진수, 8진수, 16진수================")
    println(Int.MIN_VALUE.toUInt())
    println(Int.MIN_VALUE.toUInt().toString())
    println(Int.MIN_VALUE.toUInt().toString(2))
    println(8.toUInt().toString(2))
    println(8.toUInt().toString(8))
    println(12.toUInt().toString(16))


}
