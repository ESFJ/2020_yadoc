package com.example.android02kotlin;

import com.example.android02kotlin.aaa.Test21DDD;

public class Test21javaMain {
    public static void main(String[] args){
        // public은 자바에서도 접근 가능
        Test21DDD td = new Test21DDD();
        System.out.println(td.getD3()); // public

        td.test4(); // public
    }
}
