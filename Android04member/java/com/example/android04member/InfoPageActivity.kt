package com.example.android04member

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.id_text
import kotlinx.android.synthetic.main.activity_main.name_text
import kotlinx.android.synthetic.main.activity_main.pw_text
import kotlinx.android.synthetic.main.activity_main.tel_text

class InfoPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val mDatabase: SQLiteDatabase = openOrCreateDatabase("member.db", Context.MODE_PRIVATE, null)

        // from getIntent()을 통해 intent를 받아온것임
        //intent.getStringExtra("info") // 단순 string이 넘어올때
        // intent로 넘어온게 있는지 확인
        if(intent.hasExtra("info")){
            val infos:List<String>? = intent.getStringExtra("info")?.split(":")
            Log.i("testLog", intent.getStringExtra("info").toString())
            num_text.setText(infos?.get(0))
            Log.i("testLog", "num???? ${infos?.get(0)}")
            id_text.setText(infos?.get(1))
            pw_text.setText(infos?.get(2))
            name_text.setText(infos?.get(3))
            tel_text.setText(infos?.get(4))
        }

        // Bundle로 받기
        Log.i("testLog", intent.hasExtra("bInfo").toString())
        if(intent.hasExtra("bInfo")){
            val binfo = intent.getBundleExtra("bInfo")
            Log.i("testLog", "${binfo?.getInt("num")}")

            Log.i("testLog", binfo?.getString("id").toString())
            Log.i("testLog", binfo?.getString("pw").toString())
            Log.i("testLog", binfo?.getString("name").toString())
            Log.i("testLog", binfo?.getString("tel").toString())
        }

        // Object로 받기
/*        if(intent.hasExtra("vo")){
            val vo = intent.getParcelableExtra<ListPageActivity.TestVO>("vo")
            Log.i("testLog", vo?.num.toString())
            Log.i("testLog", vo?.id.toString())
            Log.i("testLog", vo?.pw.toString())
            Log.i("testLog", vo?.name.toString())
            Log.i("testLog", vo?.tel.toString())
        }*/
        update.setOnClickListener {
            Log.i("testLog", "id:${id_text.text}, pw:${pw_text.text}, name:${name_text.text}, tel:${tel_text.text}")

            var result_up = ContentValues()
            result_up.put("id", id_text.text.toString())
            result_up.put("pw", pw_text.text.toString())
            result_up.put("name", name_text.text.toString())
            result_up.put("tel", tel_text.text.toString())

            val result = mDatabase.update("member", result_up, "num=?", arrayOf(num_text.text.toString()))
            // 버튼을 클릭하면 ListPageActivity 스타트
            // StartActivity(Intent object) -> intent에 실행할 액티비티 셋팅
            if(result > 0) {
                val intent = Intent(this, ListPageActivity::class.java /*가고자하는 페이지를 클래스로 변환*/)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        delete.setOnClickListener {
            Log.i("testLog", "delete item")
            val result = mDatabase.delete("member", "num=?", arrayOf(num_text.text.toString()))
            if(result > 0){
                Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListPageActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }
}