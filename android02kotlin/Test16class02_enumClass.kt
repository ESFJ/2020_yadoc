package com.example.android02kotlin

fun main() {
    println("enum class")

    println(CarName.values())
    println(CarName.BMW)
    println(CarName.Ray)
    println(CarName.OOOO)

    println(CarName.values().contentToString())
    CarName.values().forEach { print("$it ") }
    println()

    println("-------PRODUCT-------")
    println(Product.BMW)
    println(Product.Ray)
    println(Product.OOOO)

    println(Product.BMW.pp())
    println(Product.Ray.pp())
    println(Product.OOOO.pp())

    println(getProduct(Product.BMW))
    println(getProduct(Product.Ray))
    println(getProduct(Product.OOOO))

}

// enum class를 함수에서 이용하는 경우
fun getProduct(p:Product) = when(p){
    Product.BMW -> "Good"
    Product.Ray -> "Hello"
    Product.OOOO -> "Bye"
    else -> "error"
}

enum class CarName{BMW, Ray, OOOO}

// data도 넣는 경우
enum class Product(var price:Int, var power:Int){
    BMW(1000,100),
    Ray(2000,200),
    OOOO(3000,300);  // 세미콜론 필수!!!!
    
    // enum class 내부에서 함수 생성 가능
    fun pp() = price * power
}

// enum class의 확장판으로 클래스를 담을수있다.
sealed class Zoo(val name:String){
    class Tiger(name:String, val eye:String):Zoo(name)  // Zoo.Tiger 로 접근 가능
    fun fn(){
        println("이런 식으로 함수도 만들 수 있다.")
    }
}