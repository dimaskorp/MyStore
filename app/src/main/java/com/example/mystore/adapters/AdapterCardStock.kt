package com.example.mystore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystore.R
import com.example.mystore.data_models.ItemsCardStock


class AdapterCardStock(private val mList: List<ItemsCardStock>) :
    RecyclerView.Adapter<AdapterCardStock.ViewHolder>() {
    private var count: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_stock, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.tvName.text = itemsViewModel.name
        holder.tvVes.text = itemsViewModel.ves
        holder.tvPriceOld.text = itemsViewModel.priceOld
        holder.tvPrice.text = itemsViewModel.price
        holder.discount.text = itemsViewModel.discount
        holder.tvSum.text = itemsViewModel.price
        holder.new.visibility = if (itemsViewModel.new) View.VISIBLE else View.GONE

        holder.addButton.setOnClickListener {
            holder.rlAdd.visibility = View.GONE
            holder.cvAdd.visibility = View.VISIBLE
            holder.tvSum.visibility = View.VISIBLE
            holder.tvAdd.text = "$count"
        }

        holder.btPlus.setOnClickListener {
            count += 1
            holder.tvAdd.text = "$count"
        }

        holder.btMinus.setOnClickListener {
            if (count > 1) {
                count -= 1
                holder.tvAdd.text = "$count"
            } else {
                holder.rlAdd.visibility = View.VISIBLE
                holder.cvAdd.visibility = View.GONE
                holder.tvSum.visibility = View.GONE
            }
        }

        holder.itemView.setOnClickListener {
            println("Выбран элемент -> ${mList[position].name}")
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvVes: TextView = itemView.findViewById(R.id.tvVes)
        val tvPriceOld: TextView = itemView.findViewById(R.id.tvPriceOld)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val discount: TextView = itemView.findViewById(R.id.discount)
        val new: CardView = itemView.findViewById(R.id.cardViewNew)
        val addButton: Button = itemView.findViewById(R.id.addButton)

        val btMinus: Button = itemView.findViewById(R.id.btMinus)
        val tvAdd: TextView = itemView.findViewById(R.id.tvAdd)
        val tvSum: TextView = itemView.findViewById(R.id.tvSum)
        val btPlus: Button = itemView.findViewById(R.id.btPlus)

        val cvAdd: CardView = itemView.findViewById(R.id.cvAdd)
        val rlAdd: RelativeLayout = itemView.findViewById(R.id.rlAdd)


    }
}