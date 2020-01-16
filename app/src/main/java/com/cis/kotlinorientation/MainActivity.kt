package com.cis.kotlinorientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/* viewmodel 을 사용하면 onSavedInstance 를 쓰지 않아도 됨 */
/* orientation 을 고정시키고 싶다면 androidManifest.xml activity 항목에 screenOrientation을 지정해주면 됨 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            tv.text = savedInstanceState.getString("data1")
        }

        btn1.setOnClickListener {
            tv.text = et.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putString("data1", tv.text.toString())
    }
}
