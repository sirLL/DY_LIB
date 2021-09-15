package com.example.dydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import cn.dianyinhuoban.hm.mvp.home.view.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView).setOnClickListener {
            startActivity(Intent(MainActivity@this,HomeActivity::class.java))
        }
    }
}