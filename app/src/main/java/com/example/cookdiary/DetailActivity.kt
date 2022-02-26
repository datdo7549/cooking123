package com.example.cookdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var b1: TextView
    private lateinit var b2: TextView
    private lateinit var b3: TextView
    private lateinit var b4: TextView
    private lateinit var b5: TextView

    private lateinit var i1: ImageView
    private lateinit var i2: ImageView
    private lateinit var i3: ImageView
    private lateinit var i4: ImageView
    private lateinit var i5: ImageView

    private lateinit var num: EditText
    private lateinit var comment: EditText
    private lateinit var btnRating: Button
    private lateinit var btnEDit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        val id = bundle?.getString("ID")
        val dish = SharePreferenceUtils.getDish(id!!, this)

        name = findViewById(R.id.name)
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

        btnRating = findViewById(R.id.btn_rating)
        btnEDit = findViewById(R.id.btn_edit)
        num = findViewById(R.id.rating)
        comment = findViewById(R.id.comment)

        name.text = dish.name
        b1.text = dish.step1
        b2.text = dish.step2
        b3.text = dish.step3
        b4.text = dish.step4
        b5.text = dish.step5

        Glide.with(this).load(dish.url1).into(i1)
        Glide.with(this).load(dish.url2).into(i2)
        Glide.with(this).load(dish.url3).into(i3)
        Glide.with(this).load(dish.url4).into(i4)
        Glide.with(this).load(dish.url5).into(i5)

        val i = SharePreferenceUtils.getRating(dish.id!!, this)
        num.setText(i.toString())
        comment.setText(SharePreferenceUtils.getComment(dish.id, this))
        btnRating.setOnClickListener {
            SharePreferenceUtils.saveRating(dish.id!!, num.text.toString().toInt(), comment.text.toString(), this)
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnEDit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            val bundle = Bundle()
            bundle.putString("ID", id)
            intent.putExtras(bundle)

            startActivity(intent)
        }
    }
}