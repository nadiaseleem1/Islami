package com.example.islami.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadeethNameBinding

class HadeethNamesAdapter(private val items: List<String>) :
    RecyclerView.Adapter<HadeethNamesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHadeethNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.hadeethName.text = items[position]
        holder.itemView.setOnClickListener {
            onHadeethClick.invoke(position)
        }
    }

    class ViewHolder(val binding: ItemHadeethNameBinding) : RecyclerView.ViewHolder(binding.root)

    lateinit var onHadeethClick: ((Int) -> Unit)

}