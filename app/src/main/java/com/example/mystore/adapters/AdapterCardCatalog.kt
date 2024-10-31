package com.example.mystore.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystore.R
import com.example.mystore.data_models.ItemsCardCatalog

class AdapterCardCatalog(private val mList: List<ItemsCardCatalog>) : RecyclerView.Adapter<AdapterCardCatalog.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_catalog, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.textView.text = itemsViewModel.text
        holder.cardView.backgroundTintList = ColorStateList.valueOf(itemsViewModel.color)
        holder.itemView.setOnClickListener {
            println("Выбран элемент -> ${mList[position].text}")
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}
