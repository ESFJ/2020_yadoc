package com.example.android04member

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_list.*
import java.io.Serializable

class ListPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val mDatabase: SQLiteDatabase = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null)



        // select
        val c: Cursor = mDatabase.query("member",
            null,
            null, null,
            null, null,
            "num desc")

//        var datas = Array(30, {i -> "aaa${i+1}"})
//        datas.forEach { Log.i("testLog", it) }

        var list = arrayListOf<String>()
        c.moveToFirst()
        while(!(c.isAfterLast())) {
            // db정보 가져옴
            // loop 돌면서 log찍음

            val num = c.getInt(c.getColumnIndex("num"))
            val id = c.getString(c.getColumnIndex("id"))
            val pw = c.getString(c.getColumnIndex("pw"))
            val name = c.getString(c.getColumnIndex("name"))
            val tel = c.getString(c.getColumnIndex("tel"))

            list.add("$num:$id:$pw:$name:$tel")
            c.moveToNext()
        }
        Log.i("testLog", "Size : ${list.size}")

//        Log.i("testLog", list.size.toString())
//        for(i in 1..30){
//            list.add("$i:admin$i:hi1234$i:kim$i:010$i")
//        }
//        Log.i("testLog", list.size.toString())
//        list.forEach { Log.i("testLog", it) }

        // android Context <- Activity <- AppCompatActivity <- ListPageActivity
        // resource = ResID type의 int // R.~ 으로 접근 가능한 것을 넣어라
        // 우리가 가지고있는건 R이고 안드로이드가 가지고있는건 android.R.~ 으로 접근
//        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas)
//        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = ArrayAdapter<String>(this, R.layout.layout_list, list)

        // 무슨 item이 눌렸는지 이벤트처리로 확인
        listView.setOnItemClickListener{adapterView, view, position, id ->
//            Log.i("testLog", "${position}, ${datas[position]}")
            Log.i("testLog", "${position}, ${list.get(position)}")

            // 화면에 말풍선으로 나왔다 사라지는 그거 : Toast
            Toast.makeText(this, "${list.get(position)}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, InfoPageActivity::class.java)
            intent.putExtra("info", "${list.get(position)}")
            
            // data가 따로 있는 경우
            val num = 99
            val id = "tester"
            val pw = "hi4444"
            val name = "lee"
            val tel = "02"

            // 그냥 하나씩 넣는 경우
            intent.putExtra("num", num)
            intent.putExtra("id", id)
            intent.putExtra("pw", pw)
            intent.putExtra("name", name)
            intent.putExtra("tel", tel)

            // 한번에 Bundle을 이용해 보내는 경우
            val bundle = Bundle()
            bundle.putInt("num", num)
            bundle.putString("id", id)
            bundle.putString("pw", pw)
            bundle.putString("name", name)
            bundle.putString("tel", tel)
            intent.putExtra("bInfo", bundle)

            // Object를 이용해 보내는 경우
            val vo = TestVO(num, id, pw, name, tel)
            intent.putExtra("vo", vo)

            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        } // end of onItemClickListener

    } // end of onCreate()

    // intent간에 object를 주는 방법
    // 직렬화해서 보내는 방법 (자바에서 주로 사용)
//    data class TestVO(val num:Int, val id:String, val pw:String, val name:String, val tel:String):Serializable

    @Parcelize // 안드로이드에서 parcelable 타입을 이용해 전달하는 방법 (코틀린에서 주로 사용)
    data class TestVO(val num:Int, val id:String, val pw:String, val name:String, val tel:String):Parcelable
} // end of class