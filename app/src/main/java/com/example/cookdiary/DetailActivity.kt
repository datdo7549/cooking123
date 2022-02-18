package com.example.cookdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        val id = bundle?.getString("ID")
        val dish = SharePreferenceUtils.getDish(id!!, this)
        Log.d("asd", "onCreate: ")
    }
}