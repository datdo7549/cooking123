package com.example.cookdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {

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

    private lateinit var btn_save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val bundle = intent.extras
        val id = bundle?.getString("ID")
        val dish = SharePreferenceUtils.getDish(id!!, this)

        btn_save = findViewById(R.id.btn_save)

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

        name.setText(dish.name)
        b1.setText(dish.step1)
        b2.setText(dish.step2)
        b3.setText(dish.step3)
        b4.setText(dish.step4)
        b5.setText(dish.step5)

        i1.setText(dish.url1)
        i2.setText(dish.url2)
        i3.setText(dish.url3)
        i4.setText(dish.url4)
        i5.setText(dish.url5)


        btn_save.setOnClickListener {
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

            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}