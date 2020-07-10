package com.example.android08gridview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class TestAdapter(val c: Context, val imgArr: Array<Int>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        // getView는 한번에 전부 X 스크롤되면서 화면에 보일때마다 한칸씩 call됨
        // position : 몇번째 idx가 call되는지 알려줌
        // convertView : 반환되어진 타입의 view의 정보를 갖고있음 (객체가 생성되어있으면 생성된걸 가져옴)
        //              : 제일 첫번째 칸을 불러올때는 null
        // p2 : view가 여러개일때 사용

        var iv:ImageView
        if(convertView == null){
            iv = ImageView(c)
        } else{
            iv = convertView as ImageView
        }

        iv.setImageResource(imgArr[position])
        return iv
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return imgArr.size
    }

}
