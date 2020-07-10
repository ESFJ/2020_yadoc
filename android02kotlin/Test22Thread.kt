package com.example.android02kotlin

import java.util.concurrent.CompletableFuture
import kotlin.concurrent.thread

fun main() {
    println("Thread")// thread로 돌아갈 문장을 따로 빼서 진행시킴
    println("start main")

    // bundle.gradle 아래 라이브러리 명세 추가 (디펜던시 추가)
    // implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:0.27.0-eap13'
    // start를 해주지 않아도 됨 // thread를 만나면 알아서 스레드로 돌아감 (외부 라이브러리 사용)
    thread(true, priority = 1, name = "t1"){  // start = true : 스레드를 즉시 실행하라는 옵션
        // priority는 스레드의 우선순위, name은 스레드에게 이름을 부여(스레드 관리가 가능)
        for(c in 111..120){
            print("$c ")
            Thread.sleep(500)
        }
    }

    //Thread 기법을 지원하는 Object들
    // 1. Thread
    Thread{
        for(c in 'a'..'j'){
            print("$c ")
            Thread.sleep(500)
        }
/*      // java식
       void run(){
            for(c in 'a'..'j'){
                print("$c ")
                Thread.sleep(500)
            }
        }*/
    }.start()  // Threading 기법 : main과 별도로 실행되도록 함
    println()

    // 2. Thread(Runnable)
    Thread(Runnable {
        for(c in 'k'..'t'){
            print("$c ")
            Thread.sleep(500)
        }
    }).start()

    // 3. Runnable(Runnable).run{}
    Thread(Runnable {
        for(i in 1..10){
            print("$i ")
            Thread.sleep(500)
        }
    }).run{start()}

    // Thread를 상속받은 클래스를 스레드로 돌리는 경우
    // 1번 방식
    val t = ThreadEx()
    t.start()

    // 2번 방식
    val r = RunnableImpl()
    Thread(r).start()
//    Thread(r).run{start()}

    println("end main")
}

// 1. Thread class를 상속받아서 구현
class ThreadEx : Thread(){
    override fun run() {
        // 처리하고싶은 내용 (서버에 요청, 응답결과 처리하는 그런거)
        for(i in 20..30){
            print("$i ")
            Thread.sleep(500)
        }
    }
}

// 2. Runnable interface를 상속받아서 구현
class RunnableImpl : Runnable{
    override fun run() {
        for(c in 'A'.. 'L'){
            print("$c ")
            Thread.sleep(500)
        }
    }

}