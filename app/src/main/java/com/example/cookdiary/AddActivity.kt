package com.example.cookdiary

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.widget.Toast

import android.graphics.BitmapFactory

import android.graphics.Bitmap

import android.R.attr.data
import android.app.Activity
import android.net.Uri
import android.widget.Button
import java.io.FileNotFoundException
import java.io.InputStream


class AddActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var b1: EditText
    private lateinit var b2: EditText
    private lateinit var b3: EditText
    private lateinit var b4: EditText
    private lateinit var b5: EditText

    private lateinit var i1: EditText
    private lateinit var i2: EditText
    private lateinit var i3: EditText
    private lateinit var i4: EditText
    private lateinit var i5: EditText

    private var uri1 = ""
    private var uri2 = ""
    private var uri3 = ""
    private var uri4 = ""
    private var uri5 = ""

    private lateinit var btn_add: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        name = findViewById(R.id.dish_name)
        b1 = findViewById(R.id.step_1_detail)
        b2 = findViewById(R.id.step_2_detail)
        b3 = findViewById(R.id.step_3_detail)
        b4 = findViewById(R.id.step_4_detail)
        b5 = findViewById(R.id.step_5_detail)


        i1 = findViewById(R.id.step_1_image)
        i2 = findViewById(R.id.step_2_image)
        i3 = findViewById(R.id.step_3_image)
        i4 = findViewById(R.id.step_4_image)
        i5 = findViewById(R.id.step_5_image)

        btn_add = findViewById(R.id.btn_add)

        btn_add.setOnClickListener {
            val count = SharePreferenceUtils.getCount(this)
            val id = "mon_" + (count + 1)
            val names = name.text.toString()
            val s1 = b1.text.toString()
            val s2 = b2.text.toString()
            val s3 = b3.text.toString()
            val s4 = b4.text.toString()
            val s5 = b5.text.toString()


            SharePreferenceUtils.addDish(
                id,
                names,
                s1,
                i1.text.toString(),
                s2,
                i2.text.toString(),
                s3,
                i3.text.toString(),
                s4,
                i4.text.toString(),
                s5,
                i5.text.toString(),
            this)
            SharePreferenceUtils.saveCount(count + 1,this)

            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}