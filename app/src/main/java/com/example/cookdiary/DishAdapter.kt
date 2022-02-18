package com.example.cookdiary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DishAdapter(private val list: ArrayList<Dish>,private val context: Context, private val onLick : (position: Int) -> Unit) : RecyclerView.Adapter<DishAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = list[position].url1
        Glide.with(context).load(url).into(holder.image);
        holder.name.text = list[position].name
        holder.image.setOnClickListener {
            onLick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}