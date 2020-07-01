package com.example.android02kotlin

fun main(){
    println("data class")

    fun fn(pvo:ProductVO){
        println("${pvo.pname}, ${pvo.price}")
    }
    fn(ProductVO())
    fn(ProductVO("pc", 300000))

    fun fn2(pvo:ProductVO) =
        if(pvo.price >=  1000000) "Big" else "Good"

    var pvo = ProductVO()
    println(fn2(pvo))
    pvo = ProductVO("PC", 300000)
    println(fn2(pvo))

    var fn3 = {pvo:ProductVO -> if(pvo.price >=  1000000) "Big" else "Good"}
    pvo = ProductVO("pc", 30000000)
    println(fn3(pvo))

    fun fn4():ProductVO{
        return ProductVO()
    }
    println(fn4().pname)

    fun fn5() = ProductVO()
    println(fn5().pname)

    var fn6 = {ProductVO()}
    println(fn6().pname)

    // [ProductVO(),ProductVO("TV", 500000)]
    var arr:Array<ProductVO> = arrayOf(ProductVO(), ProductVO("TV", 500000))
    for(pvo in arr){
        println("${pvo.pname}, ${pvo.price}")
    }

    fun create(arr:Array<ProductVO>){
        println("create().....")
        for(pvo in arr){
            println("${pvo.pname}, ${pvo.price}")
        }
    }
    create(arrayOf(ProductVO(), ProductVO("TV", 500000)))

    fun create2(list:ArrayList<ProductVO>){
        println("create2()....")
        list.forEach{
            println("${it.price}, ${it.price}")
        }
    }
    create2(arrayListOf(ProductVO(), ProductVO("TV", 500000)))

    // data class는 동일타입, 동일 데이터일때 같은 객체가 됨. ( == 오버라이드)
    println(ProductVO() == ProductVO("TV", 500000))  // 동일타입 다른 값 -> false
    println(ProductVO() == ProductVO())  // 동일타입 동일값 -> true (변수 이름이 달라도 같은 값 취급됨)
    println(ProductVO(pname = "Fan") == ProductVO(price = 50000))  // 생성자로 세팅할때 값을 하나만 주거나 해도 됨

}
// 데이터를 var로 줄 경우에만 데이터 수정 가능 (val은 불가능)
data class ProductVO(var pname:String = "notebook", var price:Int = 1000000)