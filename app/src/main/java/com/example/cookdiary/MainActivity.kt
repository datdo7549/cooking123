package com.example.cookdiary

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DishAdapter
    private lateinit var list: ArrayList<Dish>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = arrayListOf()
        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
        val count = SharePreferenceUtils.getCount(this)
        list = SharePreferenceUtils.getListDish(count,this)

        adapter = DishAdapter(list, this) {
            val intent = Intent(this, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putString("ID", list[it].id)
            intent.putExtras(bundle)

            startActivity(intent)
        }
        recyclerView = findViewById(R.id.list_dish)
        recyclerView.adapter = adapter
    }
}