package com.example.mystore.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mystore.R
import com.example.mystore.data_models.Data
import com.example.mystore.data_models.Suggestions


class AddressAdapter(private val suggestions: Suggestions, private val onClick: (String) -> Unit) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return AddressViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        suggestions.suggestions[position].data?.let { holder.bind(it, onClick) }

    }

    override fun getItemCount(): Int = suggestions.suggestions.size

    class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewStreet: TextView = itemView.findViewById(R.id.tv_street)
        private val textViewAddress: TextView = itemView.findViewById(R.id.tv_address)

        @SuppressLint("SetTextI18n")
        fun bind(address: Data, onClick: (String) -> Unit) {
            val street = if (address.street_with_type != null) address.street_with_type else ""
            val house = if (address.house != null) address.house else ""
            val city = if (address.city != null) address.city else ""

            textViewStreet.text = "$street, $house"
            textViewAddress.text = "${city},${address.region_with_type},${address.country}"
            itemView.setOnClickListener { onClick("$street, $house") }
        }
    }
}