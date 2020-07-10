package com.example.android08gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 이미지 접근
        val imgArr = arrayOf(R.drawable.logo1, R.drawable.logo2, R.drawable.logo3,
                             R.drawable.logo4, R.drawable.logo5, R.drawable.logo6,
                             R.drawable.logo7, R.drawable.logo8, R.drawable.logo9,
                             R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13)

        // 1. String 타입의 배열 받기 (text만)
//        gridView.adapter = ArrayAdapter<String>(this, R.layout.layout_list, Array<String>(30, {i -> "aaa$i"}))

        // 2. image 타입 배열 받기 (image만)
        gridView.adapter = TestAdapter(this, imgArr)

        // 3. image + text
        var list:ArrayList<Item> = arrayListOf()
        list.add(Item("kim1", R.drawable.logo1))
        list.add(Item("kim2", R.drawable.logo2))
        list.add(Item("kim3", R.drawable.logo3))
        list.add(Item("kim4", R.drawable.logo4))
        list.add(Item("kim5", R.drawable.logo5))
        list.add(Item("kim6", R.drawable.logo6))
        list.add(Item("kim7", R.drawable.logo7))
        list.add(Item("kim8", R.drawable.logo8))
        list.add(Item("kim9", R.drawable.logo9))
        list.add(Item("kim10", R.drawable.logo10))
        list.add(Item("kim11", R.drawable.logo11))
        list.add(Item("kim12", R.drawable.logo12))
        list.add(Item("kim13", R.drawable.logo13))

        gridView.adapter = TxtImgAdapter(this, R.layout.txt_img, list)

        gridView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
        }
    }
}
