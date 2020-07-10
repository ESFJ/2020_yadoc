package com.example.android04member

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mDatabase: SQLiteDatabase = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null)
        // if not exists 옵션이 없으면 계속 테이블을 만드려고 해서 오류가 남 (db안의 모든 테이블은 유니크)
        // sqlite라는 로컬 db를 사용해 db접근
        mDatabase.execSQL("create table if not exists member(num integer primary key autoincrement, id text, pw text, name text, tel text)")

        button.setOnClickListener {
            Log.i("testLog", "id:${id_text.text}, pw:${pw_text.text}, name:${name_text.text}, tel:${tel_text.text}")

            var values = ContentValues()
            values.put("id","${id_text.text}")
            values.put("pw","${pw_text.text}")
            values.put("name","${name_text.text}")
            values.put("tel","${tel_text.text}")

            var result = mDatabase.insert("member",null, values)

            if(result > 0){
                // 버튼을 클릭하면 ListPageActivity 스타트
                val intent = Intent(this, ListPageActivity::class.java /*가고자하는 페이지를 클래스로 변환*/)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)  // intent에 실행할 액티비티 셋팅
            } else{
                Toast.makeText(this, "잘못된 입력", Toast.LENGTH_SHORT).show()
            }

        }
    }
}