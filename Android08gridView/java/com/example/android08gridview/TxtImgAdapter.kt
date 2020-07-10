package com.example.android08gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TxtImgAdapter(val c: Context, val txtImg: Int, val list: ArrayList<Item>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        // image + text 인 view가 필요
        var v:View? = convertView
        val inflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater // 해당 레이아웃 객체를 반환
        v = inflater.inflate(txtImg, null) // setContentView 해준것과 같음

        // v 초기화
        var iv:ImageView = v.findViewById(R.id.img)
        var tv:TextView = v.findViewById(R.id.txt)
        
        iv.setImageResource(list.get(position).img)
        tv.text = list.get(position).txt

        return v
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        // 객체 배열의 사이즈
        return list.size
    }

}
