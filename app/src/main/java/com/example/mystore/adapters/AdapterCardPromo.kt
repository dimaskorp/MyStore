package com.example.mystore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystore.R
import com.example.mystore.data_models.ItemsCardPromo


class AdapterCardPromo(private val mList: List<ItemsCardPromo>) : RecyclerView.Adapter<AdapterCardPromo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_promo, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.itemView.setOnClickListener {
            println("Выбран элемент -> ${mList[position]}")
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}