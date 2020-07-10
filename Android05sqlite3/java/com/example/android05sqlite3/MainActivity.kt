package com.example.android05sqlite3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Database를 열거나 생성
        // db이름, 여는 모드, 팩토리(사용안하면 null)
        val mDatabase:SQLiteDatabase = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null)

        mDatabase.execSQL("create table if not exists member(num integer primary key autoincrement, id text, pw text, name text, tel text)")

//        mDatabase.execSQL("create table if not exists member(num integer primary key autoincrement," +
//                "id text," +
//                "pw text," +
//                "name text, " +
//                "tel text)")

        var values = ContentValues()
        values.put("id","admin1")
        values.put("pw","hi11111")
        values.put("name","kim1")
        values.put("tel","011")

        var result = mDatabase.insert("member",null, values)
        Log.i("testLog", "result:$result")

        /* ------------------- update ------------------------ */
        //update member set id = 'aaa', pw = 'bbb', name = 'ccc', tel = 'dddd' where num = 8
        var values_up = ContentValues()
        values_up.put("id", "aaa")
        values_up.put("pw", "bbb")
        values_up.put("name", "ccc")
        values_up.put("tel", "ddd")
        // 동적으로 ?에 매칭. -> arrayOf 에 들어갈 인자를 변수처리(textView에서 가져옴)
        val result_up = mDatabase.update("member",values_up,"num=?", arrayOf("8"))
        Log.i("testLog", "result_up : $result_up")

        /* --------------------delete-------------------------- */
        val result_del = mDatabase.delete("member", "num=?", arrayOf("9"))
        Log.i("testLog", "delete result : $result_del")

        /* --------------------- select -------------------------- */
        // select * from member order by num desc;
        // rawquery : 실제 query바로 넣을떄
        // query : 간단하게 argument 넣으면 쿼리문 생성해줌
        // 볼 테이블, 볼 컬럼(전체는 null), where, 조건에 들어갈 항목, 그룹바이, 그룹바이조건, 오더바이
        val c:Cursor = mDatabase.query("member",
            null,
            null, null,
            null, null,
            "num desc")

        var list:ArrayList<String> = arrayListOf<String>()
        c.moveToFirst()
        while(!(c.isAfterLast())) {
            // db정보 가져옴
            // loop 돌면서 log찍음

            val num = c.getInt(c.getColumnIndex("num"))
            val id = c.getString(c.getColumnIndex("id"))
            val pw = c.getString(c.getColumnIndex("pw"))
            val name = c.getString(c.getColumnIndex("name"))
            val tel = c.getString(c.getColumnIndex("tel"))

            Log.i("testLog", "$num")
            Log.i("testLog", "$id")
            Log.i("testLog", "$pw")
            Log.i("testLog", "$name")
            Log.i("testLog", "$tel")

            list.add("$num:$id:$pw:$name:$tel")
            // 다음으로 진행
            c.moveToNext()  // .next와 같음
        }
        Log.i("testLog", list.size.toString())
        Log.i("testLog", list.get(0).toString())



    }
}